package com.portfolio.api.dto.response;

import java.util.List;

public record ProjectResponse(
    Long id,
    String title,
    String slug,
    String summary,
    String description,
    String coverImageUrl,
    String githubUrl,
    String liveDemoUrl,
    List<TechnologyResponse> technologies
) {}