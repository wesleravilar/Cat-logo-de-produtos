package com.example.produtos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/")
public class IndexController {
    @GetMapping
    public String hello(){
        return "Catálogo de Produtos";
    }
}
