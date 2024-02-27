package com.mjc.school;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<T, R, K> {
    List<R> readAll();

    R readById(K id);

    R create(T createRequest);

    R update(T updateRequest);

    boolean deleteById(K id);
}