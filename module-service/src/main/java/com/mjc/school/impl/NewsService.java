package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.BaseService;
import com.mjc.school.dto.NewsDtoRequest;
import com.mjc.school.dto.NewsDtoResponse;
import com.mjc.school.exceptions.NotFoundException;
import com.mjc.school.impl.NewsRepository;
import com.mjc.school.mappers.NewsMapper;
import com.mjc.school.model.News;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mjc.school.exceptions.ServiceErrorCode.NEWS_ID_DOES_NOT_EXIST;
import static java.util.Optional.*;

@Service
@Component("newsService")
public class NewsService implements BaseService <NewsDtoRequest, NewsDtoResponse, Long> {

    BaseRepository <News, Long> newsRepository;

    @Autowired
    public NewsService(BaseRepository<News, Long> newRepository) {
        this.newsRepository = newRepository;
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
}
