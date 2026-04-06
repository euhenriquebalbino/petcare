//trabalho realizado por: Pedro Comper
package com.petcare.financeiro;

import com.petcare.usuario.Tutor;
import com.petcare.agendamento.Notificador;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fatura {

  private int id;
  private Tutor tutor;
  private double valor;
  private String dataEmissao;
  private String dataVencimento;
  private String status;
  private String descricaoServico;
  private Notificador notificador;

  public Fatura(int id, Tutor tutor, double valor, String descricaoServico, Notificador notificador) {
    this.id = id;
    this.tutor = tutor;
    this.valor = valor;
    this.descricaoServico = descricaoServico;
    this.notificador = notificador;
    this.status = "PENDENTE";

    LocalDate dataAtual = LocalDate.now();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    this.dataEmissao = dataAtual.format(formatador);
    this.dataVencimento = dataAtual.plusDays(15).format(formatador);
  }

  public void emitir() {
    if (this.notificador != null) {
      this.notificador.enviarFatura(this);
    }
    JOptionPane.showMessageDialog(null, "Fatura emitida com sucesso.", "Emissão de Fatura",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public String gerarBoleto() {
    return "00000.00000 00000.000000 00000.000000 0 00000000000000";
  }

  public String gerarLinkPagamento() {
    return "https://petcare.com/pagamento/" + this.id;
  }

  public void registrarPagamento() {
    this.status = "PAGO";
    JOptionPane.showMessageDialog(null, "Pagamento da fatura ID " + this.id + " registrado com sucesso.",
        "Pagamento Confirmado", JOptionPane.INFORMATION_MESSAGE);
  }

  public boolean confirmarPagOnline() {
    return true;
  }

  public boolean isPendente() {
    return "PENDENTE".equals(this.status);
  }

  public double getValor() {
    return valor;
  }

  public String getStatus() {
    return status;
  }

  public void exibir() {
    String nomeTutor = (this.tutor != null) ? this.tutor.getNome() : "Não identificado";

    String mensagem = "DADOS DA FATURA:\n"
        + "ID: " + this.id + "\n"
        + "Tutor: " + nomeTutor + "\n"
        + "Serviço: " + this.descricaoServico + "\n"
        + "Valor: R$ " + this.valor + "\n"
        + "Emissão: " + this.dataEmissao + "\n"
        + "Vencimento: " + this.dataVencimento + "\n"
        + "Status: " + this.status;

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes Financeiros", JOptionPane.INFORMATION_MESSAGE);
  }
}
