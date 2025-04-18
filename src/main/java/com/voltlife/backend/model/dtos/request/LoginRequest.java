package com.voltlife.backend.model.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo para enviar credenciais de login.")
public class LoginRequest {
    @Schema(description = "Nome de usuário ou email.", example = "usuario@example.com", required = true)
    private String email;

    @Schema(description = "Senha do usuário.", example = "SenhaForte123", required = true)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}