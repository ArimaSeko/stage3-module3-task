package com.mjc.school.dto;

import java.time.LocalDateTime;

public record NewsDtoResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createDate,
        LocalDateTime lastUpdateTime,
        Long authorId
) {
}
