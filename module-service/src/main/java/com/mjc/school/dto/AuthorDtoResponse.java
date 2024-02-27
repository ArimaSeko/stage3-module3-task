package com.mjc.school.dto;

import java.time.LocalDateTime;

public record AuthorDtoResponse (
        Long id,
        String name,
        LocalDateTime createDate,
        LocalDateTime lastUpdateTime
){
}
