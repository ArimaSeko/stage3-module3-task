package com.mjc.school.mappers;

import com.mjc.school.dto.NewsDtoResponse;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.model.News;
import com.mjc.school.model.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List<NewsDtoResponse> ListToDtoList(List<Tag> tagList);
    Tag dtoToModel(TagDtoRequest tagDtoRequest);
    TagDtoResponse ModelToDto(Tag tag);
}
