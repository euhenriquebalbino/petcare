//trabalho realizado por: Henrique Balbino
package com.petcare.usuario;

import javax.swing.JOptionPane;

public abstract class Usuario {

  private int id;
  private String nome;
  private String email;
  private String senha;
  private String perfil;
  private boolean ativo;

  public Usuario(int id, String nome, String email, String senha, String perfil) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.perfil = perfil;
    this.ativo = true;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getPerfil() {
    return perfil;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void ativar() {
    this.ativo = true;
  }

  public void desativar() {
    this.ativo = false;
  }

  public void exibir() {
    String status = this.ativo ? "Ativo" : "Inativo";

    String mensagem = "--- DADOS BÁSICOS DO USUÁRIO ---\n"
        + "ID: " + this.id + "\n"
        + "Nome: " + this.nome + "\n"
        + "E-mail: " + this.email + "\n"
        + "Perfil: " + this.perfil + "\n"
        + "Status: " + status;

    JOptionPane.showMessageDialog(null, mensagem, "Informações de Conta", JOptionPane.INFORMATION_MESSAGE);
  }
}