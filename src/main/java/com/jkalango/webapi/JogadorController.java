package com.jkalango.webapi;

import org.springframework.web.bind.annotation.RestController;

import com.jkalango.webapi.jogadores.DadosCadastroJogador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/jogador")

public class JogadorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroJogador dados){
        System.out.println(dados);

    }

}
