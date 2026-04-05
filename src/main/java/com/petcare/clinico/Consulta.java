//trabalho realizado por: Luan Oliveira
package com.petcare.clinico;

import com.petcare.usuario.Veterinario;

import javax.swing.JOptionPane;

public class Consulta extends RegistroClinico {

  private String motivo;
  private String prescricao;
  private String dataRetorno;

  public Consulta(int id, String data, String descricao, Veterinario veterinario, String motivo) {
    super(id, data, descricao, veterinario);
    this.motivo = motivo;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setPrescricao(String prescricao) {
    if (prescricao != null && !prescricao.trim().isEmpty()) {
      this.prescricao = prescricao;
    } else {
      JOptionPane.showMessageDialog(null, "A prescrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getPrescricao() {
    return prescricao;
  }

  public void setDataRetorno(String dataRetorno) {
    this.dataRetorno = dataRetorno;
  }

  public String getDataRetorno() {
    return dataRetorno;
  }

  @Override
  public void exibir() {
    super.exibir();

    String mensagem = "=== DADOS DA CONSULTA ===\n"
        + "Motivo: " + this.motivo + "\n"
        + "Prescrição: " + (this.prescricao != null ? this.prescricao : "Nenhuma") + "\n"
        + "Data de Retorno: " + (this.dataRetorno != null ? this.dataRetorno : "Não agendado");

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes", JOptionPane.INFORMATION_MESSAGE);
  }
}