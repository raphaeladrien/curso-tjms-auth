package br.jus.tjms.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidor")
public class Servidor {

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public String listarServidores() {
        return "listar servidores";
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String cadastrar() {
        return "cadastrar servidor";
    }
}
