package com.portfolio.api.dto.response;

public record TechnologyResponse(
    Long id,
    String name,
    String category, // Exposto como String, não como Enum, para facilitar no frontend
    String iconKey
) {}