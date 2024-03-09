package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseByTagRepository;
import com.mjc.school.repository.BaseRepository;
import com.mjc.school.service.BaseByTagService;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.exceptions.NotFoundException;
import com.mjc.school.service.mappers.NewsMapper;
import com.mjc.school.repository.model.News;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mjc.school.service.exceptions.ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST;

@Service("newsService")
public class NewsService implements BaseService <NewsDtoRequest, NewsDtoResponse, Long>, BaseByTagService <NewsDtoResponse, Long> {

    private final BaseRepository <News, Long> newsRepository;
    private final BaseByTagRepository <News, Long> byTagRepository;

    @Autowired
    public NewsService(BaseRepository<News, Long> newRepository, BaseByTagRepository<News, Long> byTagRepository) {
        this.newsRepository = newRepository;
        this.byTagRepository = byTagRepository;
    }

    NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);
    @Override
    public List<NewsDtoResponse> readAll() {
        return newsMapper.modelListToDtoList( newsRepository.readAll());
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return newsRepository
                .readById(id)
                .map(newsMapper::newsToDto)
                .orElseThrow(
                        () -> new NotFoundException(String.format(NEWS_ID_DOES_NOT_EXIST.getMessage(), id)));
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        News newsRQ =newsMapper.dtoToModel(createRequest);
        News newsRP = newsRepository.create(newsRQ);
        return newsMapper.newsToDto(newsRP);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<NewsDtoResponse>  byTagName(String name) {
        return newsMapper.modelListToDtoList(byTagRepository.byTagName(name));
    }

    @Override
    public List<NewsDtoResponse>  byTagId(Long id) {
        return newsMapper.modelListToDtoList(byTagRepository.byTagId(id));
    }

    @Override
    public List<NewsDtoResponse>  byAuthorName(String authorName) {
        return newsMapper.modelListToDtoList(byTagRepository.byAuthorName(authorName));
    }

    @Override
    public NewsDtoResponse byTitle(String title) {
        return newsMapper.newsToDto(byTagRepository.byTitle(title));
    }

    @Override
    public NewsDtoResponse byContent(String content) {
        return newsMapper.newsToDto(byTagRepository.byContent(content));
    }
}
