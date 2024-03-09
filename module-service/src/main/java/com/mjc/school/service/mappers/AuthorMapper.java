package com.mjc.school.service.mappers;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.model.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    List<AuthorDtoResponse> modelListToDtoList(List<Author> authorModels);

    AuthorDtoResponse modelToDto(Author authorModel);

    Author dtoToModel(AuthorDtoRequest authorModelRequest);
}


