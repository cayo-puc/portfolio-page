package com.portfolio.api.service;

import com.portfolio.api.domain.entity.Project;
import com.portfolio.api.domain.entity.Technology;
import com.portfolio.api.dto.response.ProjectResponse;
import com.portfolio.api.dto.response.TechnologyResponse;
import com.portfolio.api.exception.ResourceNotFoundException;
import com.portfolio.api.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    /**
     * Retorna a listagem completa de projetos ordenada.
     */
    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Retorna apenas os projetos marcados como destaque (ex: para a Home).
     */
    @Transactional(readOnly = true)
    public List<ProjectResponse> getFeaturedProjects() {
        return projectRepository.findByFeaturedTrueOrderByDisplayOrderAsc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    /**
     * Busca um projeto específico pelo slug para a página de detalhes.
     */
    @Transactional(readOnly = true)
    public ProjectResponse getProjectBySlug(String slug) {
        Project project = projectRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com o slug: " + slug));
        
        return mapToResponse(project);
    }

    // --- Métodos Privados de Mapeamento (Entity -> DTO) ---

    private ProjectResponse mapToResponse(Project project) {
        List<TechnologyResponse> techResponses = project.getTechnologies().stream()
                .map(this::mapTechnologyToResponse)
                .toList();

        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getSlug(),
                project.getSummary(),
                project.getDescription(),
                project.getCoverImageUrl(),
                project.getGithubUrl(),
                project.getLiveDemoUrl(),
                techResponses
        );
    }

    private TechnologyResponse mapTechnologyToResponse(Technology tech) {
        return new TechnologyResponse(
                tech.getId(),
                tech.getName(),
                tech.getCategory().name(), // Converte o Enum para String explicitamente
                tech.getIconKey()
        );
    }
}