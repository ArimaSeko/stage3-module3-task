package com.mjc.school.implementation;

import com.mjc.school.BaseController;
import com.mjc.school.dto.NewsDtoRequest;
import com.mjc.school.dto.NewsDtoResponse;
import com.mjc.school.impl.NewsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Component("newsController")
public class NewsController implements BaseController <NewsDtoRequest, NewsDtoResponse, Long>  {

    @Override
    public List<NewsDtoResponse> readAll() {
        return null;
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return null;
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
