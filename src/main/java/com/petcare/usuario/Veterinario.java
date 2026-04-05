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

    String status = disponivel ? "Disponível" : "Indisponível";
    JOptionPane.showMessageDialog(null,
        "O status do(a) veterinário(a) foi alterado para: " + status,
        "Atualização de Status",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public void registrarLaudo(int idRegistro, String texto) {
    if (texto != null && !texto.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "Laudo registrado com sucesso para o registro clínico ID: " + idRegistro + "\nResumo: " + texto,
          "Registro de Laudo",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro: O texto do laudo não pode estar vazio.",
          "Erro de Validação",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public void emitirPrescricao(int idRegistro, String rx) {
    if (rx != null && !rx.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "Prescrição médica emitida com sucesso (Registro ID: " + idRegistro + ")\nReceita: " + rx,
          "Emissão de Prescrição",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro: A prescrição não pode estar vazia.",
          "Erro de Validação",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public List<String> consultarAgenda() {
    JOptionPane.showMessageDialog(null,
        "Buscando agenda de atendimentos do Dr(a). " + this.getNome() + "...",
        "Consulta de Agenda",
        JOptionPane.INFORMATION_MESSAGE);
    return new ArrayList<>();
  }

  @Override
  public void exibir() {
    super.exibir();
    String status = this.disponivel ? "Disponível para atendimento" : "Indisponível no momento";
    String mensagem = "=== DADOS DO VETERINÁRIO ===\n"
        + "CRMV: " + this.crmv + "\n"
        + "Especialidade: " + this.especialidade + "\n"
        + "Status: " + status;
    JOptionPane.showMessageDialog(null, mensagem, "Perfil do Veterinário", JOptionPane.INFORMATION_MESSAGE);
  }
}
