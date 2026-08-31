package com.portfolio.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactMessageRequest(

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 120, message = "O nome deve ter entre 2 e 120 caracteres.")
    String senderName,

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    String senderEmail,

    @NotBlank(message = "O assunto é obrigatório.")
    @Size(max = 200, message = "O assunto não pode exceder 200 caracteres.")
    String subject,

    @NotBlank(message = "A mensagem não pode estar vazia.")
    @Size(min = 10, max = 2000, message = "A mensagem deve ter entre 10 e 2000 caracteres.")
    String message
) {}