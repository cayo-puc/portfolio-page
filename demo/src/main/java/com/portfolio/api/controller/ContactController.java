package com.portfolio.api.controller;

import com.portfolio.api.dto.request.ContactMessageRequest;
import com.portfolio.api.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    /**
     * POST /api/v1/contact
     * Recebe, valida e processa uma nova mensagem de contato.
     */
    @PostMapping
    public ResponseEntity<Void> sendContactMessage(@Valid @RequestBody ContactMessageRequest request) {
        contactService.processNewContactMessage(request);
        
        // Retorna HTTP 201 (Created) sem corpo de resposta, pois o frontend
        // só precisa confirmar que a requisição foi bem-sucedida.
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}