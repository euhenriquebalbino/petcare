//trabalho realizado por: Luan Oliveira
package com.petcare.clinico;

import com.petcare.usuario.Veterinario;

import javax.swing.JOptionPane;

public abstract class RegistroClinico {

  private int id;
  private String data;
  private String descricao;
  private Veterinario veterinario;
  private String laudoAnexo;
  private boolean finalizado;

  public RegistroClinico(int id, String data, String descricao, Veterinario veterinario) {
    this.id = id;
    this.data = data;
    this.descricao = descricao;
    this.veterinario = veterinario;
    this.finalizado = false;
  }

  public int getId() {
    return id;
  }

  public String getData() {
    return data;
  }

  public Veterinario getVeterinario() {
    return veterinario;
  }

  public boolean isFinalizado() {
    return finalizado;
  }

  public String getLaudo() {
    return laudoAnexo;
  }

  public void finalizar() {
    if (!this.finalizado) {
      this.finalizado = true;
      JOptionPane.showMessageDialog(null, "Registro clínico finalizado e bloqueado para edições.", "Status Atualizado",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Este registro já está finalizado.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
  }

  public void anexarLaudo(String path) {
    if (this.finalizado) {
      JOptionPane.showMessageDialog(null, "Não é possível anexar laudo: Registro finalizado.", "Acesso Negado",
          JOptionPane.ERROR_MESSAGE);
    } else if (path != null && !path.trim().isEmpty()) {
      this.laudoAnexo = path;
      JOptionPane.showMessageDialog(null, "Laudo anexado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Caminho do laudo inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void exibir() {
    String status = this.finalizado ? "Finalizado" : "Em Aberto";
    String nomeVet = (this.veterinario != null) ? this.veterinario.getNome() : "Não informado";
    String laudo = (this.laudoAnexo != null) ? this.laudoAnexo : "Nenhum";

    String mensagem = "=== REGISTRO CLÍNICO ===\n"
        + "ID: " + this.id + "\n"
        + "Data: " + this.data + "\n"
        + "Descrição: " + this.descricao + "\n"
        + "Veterinário: " + nomeVet + "\n"
        + "Status: " + status + "\n"
        + "Laudo Anexo: " + laudo;

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes do Registro", JOptionPane.INFORMATION_MESSAGE);
  }
}