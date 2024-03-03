package com.mjc.school.implementation;

import com.mjc.school.BaseController;
import com.mjc.school.BaseService;
import com.mjc.school.dto.AuthorDtoRequest;
import com.mjc.school.dto.AuthorDtoResponse;
import com.mjc.school.dto.NewsDtoRequest;
import com.mjc.school.dto.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Component("authorController")
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> {
    @Qualifier("authorService")
    private BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> authorService;
    public AuthorController(BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> authorService) {
        this.authorService = authorService;
    }
    @Override
    public List<AuthorDtoResponse> readAll() {
        return authorService.readAll();
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        return authorService.readById(id);
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
