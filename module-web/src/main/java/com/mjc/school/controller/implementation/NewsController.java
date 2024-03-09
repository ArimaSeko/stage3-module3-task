package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseByTagController;
import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.annotation.CommandBody;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.annotation.CommandParam;
import com.mjc.school.service.BaseByTagService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Component("newsController")
public class NewsController implements BaseController <NewsDtoRequest, NewsDtoResponse, Long>, BaseByTagService <NewsDtoResponse, Long> {
    @Qualifier("newsService")
    private final NewsService newsService;


    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    @CommandHandler(operation = 1)
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @Override
    @CommandHandler(operation = 2)
    public NewsDtoResponse readById(@CommandParam(name = "id") Long id) {
        return newsService.readById(id);
    }

    @Override
    @CommandHandler(operation = 3)
    public NewsDtoResponse create(@CommandBody NewsDtoRequest dtoRequest) {
        return newsService.create(dtoRequest);
    }

    @Override
    @CommandHandler(operation = 4)
    public NewsDtoResponse update(@CommandBody NewsDtoRequest dtoRequest) {
        return newsService.update(dtoRequest);
    }

    @Override
    @CommandHandler(operation = 5)
    public boolean deleteById(@CommandParam(name = "id") Long id) {
        return newsService.deleteById(id);
    }

    @Override
    @CommandHandler(operation = 16)
    public List<NewsDtoResponse>  byTagName(String name) {
        return newsService.byTagName(name);
    }

    @Override
    @CommandHandler(operation = 17)
    public List<NewsDtoResponse> byTagId(Long id) {
        return newsService.byTagId(id);
    }

    @Override
    @CommandHandler(operation = 18)
    public List<NewsDtoResponse>  byAuthorName(String authorName) {
        return newsService.byAuthorName(authorName);
    }

    @Override
    @CommandHandler(operation = 19)
    public NewsDtoResponse byTitle(String title) {
        return newsService.byTitle(title);
    }

    @Override
    @CommandHandler(operation = 20)
    public NewsDtoResponse byContent(String content) {
        return newsService.byContent(content);
    }
}
