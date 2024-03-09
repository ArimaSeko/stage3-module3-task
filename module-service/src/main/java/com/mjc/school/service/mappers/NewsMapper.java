package com.mjc.school.service.mappers;

import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.repository.model.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<NewsDtoResponse> modelListToDtoList(List<News> newsModel);

    NewsDtoResponse newsToDto(News news);
    @Mappings({
            @Mapping(target = "createDate", ignore = true),
            @Mapping(target = "lastUpdateTime", ignore = true)
    })
    News dtoToModel(NewsDtoRequest newsRequest);
}
