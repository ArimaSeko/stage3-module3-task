package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record AuthorDtoRequest(
        Long id,
        String name,
        LocalDateTime createDate,
        LocalDateTime lastUpdateTime
) {
}
