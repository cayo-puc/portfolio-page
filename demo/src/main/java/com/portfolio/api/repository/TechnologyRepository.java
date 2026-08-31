package com.portfolio.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.api.domain.entity.Technology;
import com.portfolio.api.domain.enums.TechnologyCategory;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

    /**
     * Busca tecnologias filtrando por categoria (ex: BACKEND) e ordenando alfabeticamente.
     */
    List<Technology> findByCategoryOrderByNameAsc(TechnologyCategory category);
}