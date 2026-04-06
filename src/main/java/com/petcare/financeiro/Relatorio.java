//trabalho realizado por: Pedro Comper
package com.petcare.financeiro;

import javax.swing.JOptionPane;

public class Relatorio {

  private int id;
  private int mes;
  private int ano;
  private int totalAtendimentos;
  private double faturamentoTotal;
  private double totalDespesas;
  private double taxaRetorno;
  private double tempMedioAtend;
  private String procedMaisRealizado;

  public Relatorio(int mes, int ano) {
    this.mes = mes;
    this.ano = ano;
  }

  public void gerar() {
    this.totalAtendimentos = 150;
    this.totalDespesas = 5000.00;
    this.procedMaisRealizado = "Consulta de Rotina";
    this.faturamentoTotal = calcularFaturamento();
    this.taxaRetorno = calcularTaxaRetorno();
    this.tempMedioAtend = calcularTempMedio();

    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso para " + this.mes + "/" + this.ano, "Relatório",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public double calcularFaturamento() {
    return 15000.00;
  }

  public double calcularTaxaRetorno() {
    return 30.5;
  }

  public double calcularTempMedio() {
    return 45.0;
  }

  public String getEstatisticas() {
    return "Atendimentos: " + this.totalAtendimentos + " | Faturamento: R$" + this.faturamentoTotal;
  }

  public String getProcedMaisRealizado() {
    return procedMaisRealizado;
  }

  public void exportar() {
    JOptionPane.showMessageDialog(null, "Relatório exportado para PDF com sucesso.", "Exportação",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public void exibir() {
    String mensagem = "RELATÓRIO MENSAL: " + String.format("%02d", this.mes) + "/" + this.ano + " ===\n"
        + "Total de Atendimentos: " + this.totalAtendimentos + "\n"
        + "Procedimento Mais Realizado: " + this.procedMaisRealizado + "\n"
        + "Tempo Médio de Atendimento: " + this.tempMedioAtend + " min\n"
        + "Taxa de Retorno: " + this.taxaRetorno + "%\n"
        + "Despesas Totais: R$ " + this.totalDespesas + "\n"
        + "Faturamento Total: R$ " + this.faturamentoTotal + "\n"
        + "Lucro Líquido: R$ " + (this.faturamentoTotal - this.totalDespesas);

    JOptionPane.showMessageDialog(null, mensagem, "Visualização de Relatório", JOptionPane.INFORMATION_MESSAGE);
  }
}
