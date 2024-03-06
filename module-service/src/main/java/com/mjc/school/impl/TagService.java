package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.BaseService;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component("tagService")
public class TagService implements BaseService <TagDtoRequest, TagDtoResponse, Long> {

    BaseRepository <Tag, Long> tagRepository;
    @Autowired
    public TagService(BaseRepository<Tag, Long> tagRepository) {
        this.tagRepository = tagRepository;
    }

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
