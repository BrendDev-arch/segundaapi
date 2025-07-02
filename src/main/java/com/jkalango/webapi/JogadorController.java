package com.jkalango.webapi;
import org.springframework.web.bind.annotation.RestController;
import com.jkalango.webapi.jogadores.DadosCadastroJogador;
import com.jkalango.webapi.jogadores.Jogador;
import com.jkalango.webapi.jogadores.jogadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
    // O que é Injeção de Dependência
    @Autowired
    private jogadorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody NovoJogador jogador){
        //System.out.println(dados);
         return "Jogador " + jogador.getNome() + " cadastrado com sucesso!"

    }

}
