package com.petcare.usuario;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
  private int id;
  private String nome, email, senha, perfil;
  private boolean ativo;
  private String dataCadastro;

  public Usuario(int id, String nome, String email, String senha, String perfil) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.perfil = perfil;
    this.dataCadastro = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public boolean login(String email, String senha) {
    if (this.email.equals(email) && this.senha.equals(senha) && this.ativo) {
      return true;
    }
    return false;
  }

  public void logout() {
    JOptionPane.showMessageDialog(null, "Usuário " + this.nome + " efetuou logout.");
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void desativar() {
    this.ativo = false;
  }

  public void exibir() {
    JOptionPane.showMessageDialog(null,
      "Dados do Usuário:" 
      + "\nID: " + this.id 
      + "\nNome: " + this.nome 
      + "\nEmail: " + this.email 
      + "\nPerfil: " + this.perfil 
      + "\nStatus: " + (this.ativo ? "Ativo" : "Inativo") 
      + "\nData de Cadastro: " + this.dataCadastro);
  }
}
