package com.jkalango.webapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/alo")
public class AloController {

    //requisição e respostas (REQUEST E RESPONSA)
    @GetMapping
    public String aloMundo(){
        return "Alô Mundo - JKalango!";

    }

}
