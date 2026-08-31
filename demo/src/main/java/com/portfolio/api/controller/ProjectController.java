package com.portfolio.api.controller;

import com.portfolio.api.dto.response.ProjectResponse;
import com.portfolio.api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /**
     * GET /api/v1/projects
     * Retorna a lista completa de projetos.
     */
    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    /**
     * GET /api/v1/projects/featured
     * Retorna apenas os projetos marcados como destaque (para a Home).
     */
    @GetMapping("/featured")
    public ResponseEntity<List<ProjectResponse>> getFeaturedProjects() {
        List<ProjectResponse> featuredProjects = projectService.getFeaturedProjects();
        return ResponseEntity.ok(featuredProjects);
    }

    /**
     * GET /api/v1/projects/{slug}
     * Busca os detalhes de um projeto específico utilizando o seu identificador único.
     */
    @GetMapping("/{slug}")
    public ResponseEntity<ProjectResponse> getProjectBySlug(@PathVariable String slug) {
        ProjectResponse project = projectService.getProjectBySlug(slug);
        return ResponseEntity.ok(project);
    }
}