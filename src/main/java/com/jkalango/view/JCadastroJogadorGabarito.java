package com.jkalango.view;

import javax.swing.*;

import com.jkalango.dto.NovoJogador;

import java.awt.*;
import java.sql.*;

public class JCadastroJogadorGabarito extends JFrame {
    // Dados da conexão — ajuste conforme seu ambiente!
    private static final String DB_URL = "jdbc:mysql://localhost:3307/kalangoweb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public JCadastroJogadorGabarito() {
        setTitle("Cadastro de Jogador - JKalango");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JTextField txtNome = new JTextField(30);
        JTextField txtNickname = new JTextField(30);
        JTextField txtEmail = new JTextField(30);
        JTextField txtTelefone = new JTextField(30);
        JPasswordField txtSenha = new JPasswordField(30);
        JButton btnCadastrar = new JButton("Cadastrar");

        add(new JLabel("Nome:")); add(txtNome);
        add(new JLabel("Nick Name:")); add(txtNickname);
        add(new JLabel("Email:")); add(txtEmail);
        add(new JLabel("Telefone:")); add(txtTelefone);
        add(new JLabel("Senha:")); add(txtSenha);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String nick = txtNickname.getText().trim();
            String email = txtEmail.getText().trim();
            String tel = txtTelefone.getText().trim();
            String senha = new String(txtSenha.getPassword());

            if (nome.isEmpty() || nick.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            btnCadastrar.setEnabled(false);

            new SwingWorker<Boolean, Void>() {
                private Exception erro;

                @Override
                protected Boolean doInBackground() {
                    String sql = "INSERT INTO jogador (nome, nick_name, email, telefone, senha) VALUES (?, ?, ?, ?, ?)";
                    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                         PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, nome);
                        stmt.setString(2, nick);
                        stmt.setString(3, email);
                        stmt.setString(4, tel);
                        stmt.setString(5, senha);
                        return stmt.executeUpdate() > 0;
                    } catch (SQLException ex) {
                        erro = ex;
                        return false;
                    }
                }

                @Override
                protected void done() {
                    btnCadastrar.setEnabled(true);
                    if (erro != null) {
                        JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this,
                            "Erro ao cadastrar: " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }   
                    try {
                        if (get()) {
                            JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this,
                                "Jogador cadastrado com sucesso!" , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }
                        if (get()){
                            JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this,
                            "Jogador cadastrado com sucesso!" , "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        }else {
                            JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this,
                                "Falha no cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(JCadastroJogadorGabarito.this,
                            "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }.execute();
        });

        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JCadastroJogadorGabarito::new);
    }
}
