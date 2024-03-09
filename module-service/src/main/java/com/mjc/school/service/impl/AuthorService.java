package com.mjc.school.service.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.exceptions.NotFoundException;
import com.mjc.school.service.mappers.AuthorMapper;
import com.mjc.school.model.Author;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mjc.school.service.exceptions.ServiceErrorCode.AUTHOR_ID_DOES_NOT_EXIST;

@Service
@Component("authorService")
public class AuthorService implements BaseService <AuthorDtoRequest, AuthorDtoResponse, Long> {

    private BaseRepository <Author, Long> authorRepository;

    @Autowired
    public AuthorService(BaseRepository<Author, Long> authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);


    public AuthorService() {
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorMapper.modelListToDtoList(authorRepository.readAll());
    }


    @Override
    public AuthorDtoResponse readById(Long id) {

        return authorRepository.readById(id)
                .map(authorMapper::modelToDto)
                .orElseThrow(
                        () -> new NotFoundException(String.format(AUTHOR_ID_DOES_NOT_EXIST.getMessage(), id)));
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        Author authorRq = authorMapper.dtoToModel(createRequest);
        Author authorRp = authorRepository.create(authorRq);
        return authorMapper.modelToDto(authorRp);
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        if(authorRepository.existById(updateRequest.id())){
        Author rq = authorMapper.dtoToModel(updateRequest);
        Author rp = authorRepository.update(rq);
        return authorMapper.modelToDto(rp);}
        else {
            throw new NotFoundException(
                    String.format(AUTHOR_ID_DOES_NOT_EXIST.getMessage(), updateRequest.id()));
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (authorRepository.existById(id)) {
            return authorRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format(AUTHOR_ID_DOES_NOT_EXIST.getMessage(), id));
        }
    }
}
