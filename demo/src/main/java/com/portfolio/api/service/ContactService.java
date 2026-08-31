package com.portfolio.api.service;

import com.portfolio.api.domain.entity.ContactMessage;
import com.portfolio.api.dto.request.ContactMessageRequest;
import com.portfolio.api.repository.ContactMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactMessageRepository contactMessageRepository;

    /**
     * Recebe o payload validado do controller, converte para a entidade e persiste no banco.
     */
    @Transactional
    public void processNewContactMessage(ContactMessageRequest request) {
        ContactMessage message = mapToEntity(request);
        
        contactMessageRepository.save(message);
        
        // TODO: Em uma evolução futura, você pode injetar aqui um ApplicationEventPublisher
        // para disparar um e-mail de notificação de forma assíncrona, sem travar a 
        // requisição do usuário no frontend.
    }

    // --- Métodos Privados de Mapeamento (DTO -> Entity) ---

    private ContactMessage mapToEntity(ContactMessageRequest request) {
        return ContactMessage.builder()
                .senderName(request.senderName())
                .senderEmail(request.senderEmail())
                .subject(request.subject())
                .message(request.message())
                // Não precisamos setar readStatus aqui, pois o @Builder.Default 
                // na entidade já garante que ele nasça como 'false'.
                .build();
    }
}