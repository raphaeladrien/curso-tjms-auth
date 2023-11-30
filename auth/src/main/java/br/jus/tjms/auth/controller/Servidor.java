package br.jus.tjms.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidor")
public class Servidor {

    @GetMapping("/")
    public String listarServidores() {
        return "listar servidores";
    }

    @PostMapping("/")
    public String cadastrar() {
        return "cadastrar servidor";
    }
}
