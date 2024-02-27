package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.model.Author;

import java.util.List;
import java.util.Optional;

public class AuthorRepository implements BaseRepository<Author, Long> {
    @Override
    public List<Author> readAll() {
        return null;
    }

    @Override
    public Optional<Author> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public Author create(Author entity) {
        return null;
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
