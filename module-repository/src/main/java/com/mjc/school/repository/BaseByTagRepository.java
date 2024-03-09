package com.mjc.school.repository;

import java.util.List;

public interface BaseByTagRepository <T, K> {
    List<T> byTagName(String name);
    List<T> byTagId(K id);
    List<T> byAuthorName(String authorName);
    T byTitle(String title);
    T byContent(String content);
}
