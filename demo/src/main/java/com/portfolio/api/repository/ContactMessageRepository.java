package com.portfolio.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.api.domain.entity.ContactMessage;

import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

    /**
     * Busca as mensagens que ainda não foram lidas, da mais recente para a mais antiga.
     * Útil caso implemente um painel administrativo no futuro.
     */
    List<ContactMessage> findByReadStatusFalseOrderByCreatedAtDesc();
}