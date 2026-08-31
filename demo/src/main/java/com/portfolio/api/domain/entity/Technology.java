package com.portfolio.api.domain.entity;

import com.portfolio.api.domain.enums.TechnologyCategory;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_technologies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Technology extends BaseEntity {

    @Column(nullable = false, unique = true, length = 80)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TechnologyCategory category;

    // Chave para o frontend renderizar o ícone correspondente (ex: "mdi:language-java")
    @Column(name = "icon_key", length = 100)
    private String iconKey;
}