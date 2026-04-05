package com.petcare.estoque;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class ItemEstoque {

  private int id;
  private String nome;
  private int quantidade;
  private int quantidadeMinima;
  private String lote;
  private String validade;
  private boolean controlado;
  private String responsavelRetirada;
  private String categoria;

  public ItemEstoque(int id, String nome, int quantidade, int quantidadeMinima, String lote) {
    this.id = id;
    this.nome = nome;
    this.quantidade = quantidade;
    this.quantidadeMinima = quantidadeMinima;
    this.lote = lote;
    this.controlado = false;
  }

  public void darEntrada(int qtd, String resp) {
    if (qtd > 0) {
      this.quantidade += qtd;
      this.responsavelRetirada = resp;
    } else {
      JOptionPane.showMessageDialog(null,
          "A quantidade de entrada deve ser maior que zero.",
          "Erro de Entrada",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean darSaida(int qtd, String resp) {
    if (qtd <= 0) {
      JOptionPane.showMessageDialog(null, "A quantidade de saída deve ser maior que zero.", "Erro",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }

    if (this.quantidade >= qtd) {
      this.quantidade -= qtd;
      this.responsavelRetirada = resp;
      return true;
    } else {
      return false;
    }
  }

  public boolean reservar(int qtd) {
    if (this.quantidade >= qtd) {
      this.quantidade -= qtd;
      return true;
    }
    return false;
  }

  public boolean isAbaixoMinimo() {
    return this.quantidade < this.quantidadeMinima;
  }

  public void setControlado(boolean controlado) {
    if (controlado) {
      if (this.lote == null || this.validade == null || this.responsavelRetirada == null) {
        JOptionPane.showMessageDialog(null,
            "Erro (RN09): Para ser controlado, o item deve ter lote, validade e responsável definidos.",
            "Bloqueio de Regra de Negócio",
            JOptionPane.ERROR_MESSAGE);
        return;
      }
    }
    this.controlado = controlado;
  }

  public boolean isControlado() {
    return controlado;
  }

  public boolean isVencido() {
    if (this.validade == null || !this.validade.contains("/")) {
      return false;
    }

    String[] partes = this.validade.split("/");

    if (partes.length == 3) {
      int diaVal = Integer.parseInt(partes[0]);
      int mesVal = Integer.parseInt(partes[1]);
      int anoVal = Integer.parseInt(partes[2]);

      LocalDate hoje = LocalDate.now();
      LocalDate dataValidade = LocalDate.of(anoVal, mesVal, diaVal);

      return dataValidade.isBefore(hoje);
    }

    return false;
  }

  public void exibir() {
    String statusControlado = this.controlado ? "Sim" : "Não";
    String statusVencimento = isVencido() ? "VENCIDO" : "No Prazo";
    String statusEstoque = isAbaixoMinimo() ? "ABAIXO DO MÍNIMO" : "Normal";

    String mensagem = "=== DADOS DO ITEM DE ESTOQUE ===\n"
        + "ID: " + this.id + "\n"
        + "Nome: " + this.nome + "\n"
        + "Categoria: " + (this.categoria != null ? this.categoria : "Não definida") + "\n"
        + "Quantidade Atual: " + this.quantidade + " (" + statusEstoque + ")\n"
        + "Mínimo Exigido: " + this.quantidadeMinima + "\n"
        + "Lote: " + (this.lote != null ? this.lote : "Não informado") + "\n"
        + "Validade: " + (this.validade != null ? this.validade : "Não informada") + " [" + statusVencimento + "]\n"
        + "Medicamento Controlado: " + statusControlado + "\n"
        + "Último Responsável: " + (this.responsavelRetirada != null ? this.responsavelRetirada : "Nenhum");

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes do Item", JOptionPane.INFORMATION_MESSAGE);
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public String getLote() {
    return lote;
  }

  public void setValidade(String validade) {
    this.validade = validade;
  }

  public String getValidade() {
    return validade;
  }

  public void setResponsavelRetirada(String responsavelRetirada) {
    this.responsavelRetirada = responsavelRetirada;
  }

  public String getResponsavelRetirada() {
    return responsavelRetirada;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}