//trabalho realizado por: Lorenzo Silote
package com.petcare.agendamento;

import com.petcare.animal.Animal;
import com.petcare.estoque.ItemEstoque;
import com.petcare.financeiro.Fatura;

import javax.swing.JOptionPane;
import java.util.List;

public class Notificador {

  private String canal; // EMAIL | SMS | APP
  private String destinatario;
  private boolean ativo;

  public Notificador(String canal, String destinatario) {
    this.canal = canal;
    this.destinatario = destinatario;
    this.ativo = true;
  }

  public String getCanal() {
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public void enviarConfirmacao(Agendamento ag) {
    if (this.ativo) {
      String mensagem = "CONFIRMAÇÃO DE AGENDAMENTO\n"
          + "Data/Hora: " + ag.getDataHora() + "\n"
          + "Procedimento: " + ag.getTipo() + "\n"
          + "Status: Confirmado";
      JOptionPane.showMessageDialog(null, mensagem, "Notificação: " + this.canal, JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void enviarCancelamento(Agendamento ag) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, "Aviso: O agendamento (" + ag.getTipo() + ") foi cancelado.",
          "Notificação: " + this.canal, JOptionPane.WARNING_MESSAGE);
    }
  }

  public void enviarReagendamento(Agendamento ag) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, "Aviso: O agendamento foi reagendado para " + ag.getDataHora(),
          "Notificação: " + this.canal, JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void enviarLembreteVacina(Animal a, String dt) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, "Lembrete: A vacina do pet " + a.getNome() + " vence em " + dt,
          "Notificação: " + this.canal, JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void enviarAlertaEstoque(ItemEstoque item) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, "ALERTA DE ESTOQUE: O item " + item.getNome() + " está abaixo do mínimo!",
          "Alerta do Sistema", JOptionPane.WARNING_MESSAGE);
    }
  }

  public void enviarFatura(Fatura f) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, "Sua fatura no valor de R$" + f.getValor() + " está disponível.",
          "Notificação Financeira", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void enviarAlerta(String dest, String msg) {
    if (this.ativo) {
      JOptionPane.showMessageDialog(null, msg, "Alerta para " + dest, JOptionPane.WARNING_MESSAGE);
    }
  }

  public void enviarCampanha(List<String> lista, String msg) {
    if (this.ativo && lista != null && !lista.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Campanha enviada para " + lista.size() + " clientes.\nMensagem: " + msg,
          "Marketing", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}