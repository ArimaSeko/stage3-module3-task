package com.mjc.school.controller;

import java.util.List;

public interface BaseByTagController <T, K>{
    List<T> byTagName(String name);
    List<T> byTagId(K id);
    List<T> byAuthorName(String authorName);
    T byTitle(String title);
    T byContent(String content);
}
