package com.portfolio.api.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.api.domain.entity.Project;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Busca todos os projetos ordenados pelo campo displayOrder.
     * O @EntityGraph resolve o problema de N+1 queries, forçando o carregamento 
     * das tecnologias em uma única query (JOIN FETCH) no momento da listagem.
     */
    @EntityGraph(attributePaths = "technologies")
    List<Project> findAllByOrderByDisplayOrderAsc();

    /**
     * Busca apenas os projetos marcados como destaque para a Home.
     */
    @EntityGraph(attributePaths = "technologies")
    List<Project> findByFeaturedTrueOrderByDisplayOrderAsc();

    /**
     * Busca um projeto específico pelo seu slug (ex: para a página de detalhes do projeto).
     */
    @EntityGraph(attributePaths = "technologies")
    Optional<Project> findBySlug(String slug);
}