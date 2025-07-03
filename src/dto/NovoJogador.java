package br.com.jkalango.dto;

import javax.swing.JOptionPane;

public class NovoJogador {

    private String nome;

    public NovoJogador(String nome) {      
        this.nome = nome; 

    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public String getNome() {
        if(nome.toLowerCase().contains("java")){
            JOptionPane.showMessageDialog(null, "Pode ser cadastrado");
        }else{                
            JOptionPane.showMessageDialog(null, "Esse nome não pode ser cadastrado"); 
            System.exit(0);
        }         
             return nome;
        }
    }

   
       
    




