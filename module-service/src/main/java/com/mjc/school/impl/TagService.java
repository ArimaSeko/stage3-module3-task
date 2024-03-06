package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.BaseService;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.exceptions.NotFoundException;
import com.mjc.school.mappers.TagMapper;
import com.mjc.school.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mjc.school.exceptions.ServiceErrorCode.TAG_ID_DOES_NOT_EXIST;

@Service
@Component("tagService")
public class TagService implements BaseService <TagDtoRequest, TagDtoResponse, Long> {

    BaseRepository <Tag, Long> tagRepository;

    TagMapper mapper = Mappers.getMapper(TagMapper.class);
    @Autowired
    public TagService(BaseRepository<Tag, Long> tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<TagDtoResponse> readAll() {
        return mapper.ListToDtoList(tagRepository.readAll());
    }

    @Override
    public TagDtoResponse readById(final Long id) {
        return tagRepository
                .readById(id)
                .map(mapper::modelToDto)
                .orElseThrow(
                        () -> new NotFoundException(String.format(TAG_ID_DOES_NOT_EXIST.getMessage(), id)));
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        Tag model = mapper.dtoToModel(createRequest);
        model = tagRepository.create(model);
        return mapper.modelToDto(model);
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        if (tagRepository.existById(updateRequest.id())) {
            Tag model = mapper.dtoToModel(updateRequest);
            model = tagRepository.update(model);
            return mapper.modelToDto(model);
        } else {
            throw new NotFoundException(
                    String.format(TAG_ID_DOES_NOT_EXIST.getMessage(), updateRequest.id()));
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (tagRepository.existById(id)) {
            return tagRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format(TAG_ID_DOES_NOT_EXIST.getMessage(), id));
        }
    }
}
