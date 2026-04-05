package com.petcare.clinico;

import com.petcare.usuario.Veterinario;

import javax.swing.JOptionPane;

public class Exame extends RegistroClinico {

  private String tipo;
  private String resultado;
  private String imagemAnexo;
  private String laboratorio;

  public Exame(int id, String data, String descricao, Veterinario veterinario, String tipo) {
    super(id, data, descricao, veterinario);
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setResultado(String resultado) {
    if (resultado != null && !resultado.trim().isEmpty()) {
      this.resultado = resultado;
      JOptionPane.showMessageDialog(null, "Resultado do exame registrado com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "O resultado não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getResultado() {
    return resultado;
  }

  public void anexarImagem(String path) {
    if (path != null && !path.trim().isEmpty()) {
      this.imagemAnexo = path;
      JOptionPane.showMessageDialog(null, "Imagem do exame anexada com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Caminho da imagem inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getImagem() {
    return imagemAnexo;
  }

  public String getLaboratorio() {
    return laboratorio;
  }

  public void setLaboratorio(String laboratorio) {
    this.laboratorio = laboratorio;
  }

  @Override
  public void exibir() {
    super.exibir();

    String mensagem = "=== DADOS DO EXAME ===\n"
        + "Tipo: " + this.tipo + "\n"
        + "Laboratório: " + (this.laboratorio != null ? this.laboratorio : "Não definido") + "\n"
        + "Resultado: " + (this.resultado != null ? this.resultado : "Pendente") + "\n"
        + "Imagem Anexa: " + (this.imagemAnexo != null ? this.imagemAnexo : "Nenhuma");

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes do Exame", JOptionPane.INFORMATION_MESSAGE);
  }
}