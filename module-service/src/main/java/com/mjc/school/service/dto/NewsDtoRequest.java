package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record NewsDtoRequest(
        Long id,
        String title,
        String content,
        LocalDateTime createDate,
        LocalDateTime lastUpdateTime,
        Long authorId
) {
}
