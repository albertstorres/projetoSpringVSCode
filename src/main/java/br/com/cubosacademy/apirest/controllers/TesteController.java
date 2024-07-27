package br.com.cubosacademy.apirest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // Importando o pacote do decorator


@RestController // Utilização do decorator indicando que essa classe é um controlador
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public String teste () {
        return "Tudo OK!";
    }
}
