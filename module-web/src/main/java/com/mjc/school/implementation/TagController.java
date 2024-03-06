package com.mjc.school.implementation;

import com.mjc.school.BaseController;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;

import java.util.List;

public class TagController implements BaseController <TagDtoRequest, TagDtoResponse, Long> {
    @Override
    public List<TagDtoResponse> readAll() {
        return null;
    }

    @Override
    public TagDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public TagDtoResponse create(TagDtoRequest createRequest) {
        return null;
    }

    @Override
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
