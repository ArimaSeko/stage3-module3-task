package com.mjc.school.repository;

import com.mjc.school.repository.model.BaseEntity;

import java.util.List;

public interface BaseByTagRepository <T extends BaseEntity<K>, K>  extends BaseRepository<T , K>{
    List<T> byTagName(String name);
    List<T> byTagId(K id);
    List<T> byAuthorName(String authorName);
    T byTitle(String title);
    T byContent(String content);
}
