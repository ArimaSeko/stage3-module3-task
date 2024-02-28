package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.BaseService;
import com.mjc.school.dto.AuthorDtoRequest;
import com.mjc.school.dto.AuthorDtoResponse;
import com.mjc.school.mappers.AuthorMapper;
import com.mjc.school.model.Author;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
