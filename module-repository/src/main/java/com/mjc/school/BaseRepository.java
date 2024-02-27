package com.mjc.school;

import com.mjc.school.model.BaseEntity;
import com.mjc.school.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface BaseRepository<T extends BaseEntity<K>, K> {

    List<T> readAll();

    Optional<T> readById(K id);

    T create(T entity);

    T update(T entity);

    boolean deleteById(K id);

    boolean existById(K id);
}