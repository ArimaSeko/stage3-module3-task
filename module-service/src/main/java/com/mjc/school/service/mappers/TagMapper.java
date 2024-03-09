package com.mjc.school.service.mappers;

import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import com.mjc.school.repository.model.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List<TagDtoResponse> ListToDtoList(List<Tag> tagList);
    Tag dtoToModel(TagDtoRequest tagDtoRequest);
    TagDtoResponse modelToDto(Tag tag);
}
