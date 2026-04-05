//trabalho realizado por: Henrique Balbino
package com.petcare.usuario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Veterinario extends Usuario {

  private String crmv;
  private String especialidade;
  private boolean disponivel;

  public Veterinario(int id, String nome, String email, String senha, String crmv, String especialidade) {
    super(id, nome, email, senha, "VETERINÁRIO");
    this.crmv = crmv;
    this.especialidade = especialidade;
    this.disponivel = true;
  }

  public void registrarLaudo(int idRegistro, String texto) {
    if (texto != null && !texto.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "Laudo registrado para o ID: " + idRegistro + "\nConteúdo: " + texto,
          "Registro de Laudo",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "O texto do laudo não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void emitirPrescricao(int idRegistro, String rx) {
    if (rx != null && !rx.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "Prescrição emitida (Registro: " + idRegistro + ")\nReceita: " + rx,
          "Prescrição Médica",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "A prescrição não pode estar vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public List<String> consultarAgenda() {
    JOptionPane.showMessageDialog(null, "Consultando agenda do Dr(a). " + this.getNome(), "Agenda",
        JOptionPane.INFORMATION_MESSAGE);
    return new ArrayList<>();
  }

  @Override
  public void exibir() {
    super.exibir();

    String status = this.disponivel ? "Disponível" : "Indisponível";

    String mensagem = "=== DADOS DO VETERINÁRIO ===\n"
        + "CRMV: " + this.crmv + "\n"
        + "Especialidade: " + this.especialidade + "\n"
        + "Status Atual: " + status;

    JOptionPane.showMessageDialog(null, mensagem, "Perfil Profissional", JOptionPane.INFORMATION_MESSAGE);
  }

  public String getCrmv() {
    return crmv;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }
}