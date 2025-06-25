package com.jkalango.webapi.jogadores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name="jogador")
@Entity(name="Jogador")
@Getter
@NoArgsConstructor//JPA - solicito um construtor vazio
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
    public Jogador(DadosCadastroJogador dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.nickName = dados.nickname();
        this.telefone = dados.celular();
        this.senha = dados.senha();
    }

    //única, imutável, universal
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nickName;
    private String email;
    private String telefone;
    private String senha;

}
