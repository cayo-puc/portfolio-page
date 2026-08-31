package com.portfolio.api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_contact_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessage extends BaseEntity {

    @Column(name = "sender_name", nullable = false, length = 120)
    private String senderName;

    @Column(name = "sender_email", nullable = false, length = 150)
    private String senderEmail;

    @Column(nullable = false, length = 200)
    private String subject;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "read_status", nullable = false)
    @Builder.Default
    private Boolean readStatus = false;
}
