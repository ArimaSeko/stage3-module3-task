package com.mjc.school.mappers;

import com.mjc.school.dto.AuthorDtoRequest;
import com.mjc.school.dto.AuthorDtoResponse;
import com.mjc.school.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface AuthorMapper {
    List<AuthorDtoResponse> modelListToDtoList(List<Author> authorModels);

    AuthorDtoResponse modelToDto(Author authorModel);

    Author dtoToModel(AuthorDtoRequest authorModelRequest);
}


