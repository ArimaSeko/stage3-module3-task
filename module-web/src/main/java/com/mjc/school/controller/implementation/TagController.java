package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.impl.TagService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@Component("tagController")
public class TagController implements BaseController <TagDtoRequest, TagDtoResponse, Long> {
    @Qualifier("tagService")
    private final TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    @CommandHandler(operation = 11)
    public List<TagDtoResponse> readAll() {
        return tagService.readAll();
    }

    @Override
    @CommandHandler(operation = 12)
    public TagDtoResponse readById(@CommandParam(name = "id") Long id) {
        return tagService.readById(id);
    }

    @Override
    @CommandHandler(operation = 13)
    public TagDtoResponse create(@CommandBody TagDtoRequest createRequest) {
        return tagService.create(createRequest);
    }

    @Override
    @CommandHandler(operation = 14)
    public TagDtoResponse update(@CommandBody TagDtoRequest updateRequest) {
        return tagService.update(updateRequest);
    }

    @Override
    @CommandHandler(operation = 15)
    public boolean deleteById(@CommandParam(name = "id") Long id) {
        return tagService.deleteById(id);
    }
}
