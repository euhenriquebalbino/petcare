//trabalho realizado por: Pedro Comper
package com.petcare.estoque;

import com.petcare.agendamento.Agendamento;
import com.petcare.agendamento.Notificador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Estoque {

  private List<ItemEstoque> itens;
  private Notificador notificador;

  public Estoque(Notificador notificador) {
    this.notificador = notificador;
    this.itens = new ArrayList<>();
  }

  public void adicionarItem(ItemEstoque item) {
    if (item != null) {
      this.itens.add(item);
      JOptionPane.showMessageDialog(null,
          "Item '" + item.getNome() + "' adicionado ao estoque.",
          "Cadastro de Estoque",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro ao adicionar item inválido.",
          "Erro",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  // Método auxiliar privado para reaproveitamento de código
  private ItemEstoque buscarItemPorId(int id) {
    for (ItemEstoque item : itens) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public ItemEstoque buscarItem(String nome) {
    for (ItemEstoque item : itens) {
      if (item.getNome().equalsIgnoreCase(nome)) {
        return item;
      }
    }
    JOptionPane.showMessageDialog(null, "Item '" + nome + "' não encontrado.", "Busca", JOptionPane.WARNING_MESSAGE);
    return null;
  }

  public void registrarEntrada(int id, int qtd, String resp) {
    ItemEstoque item = buscarItemPorId(id);
    if (item != null) {
      item.darEntrada(qtd, resp);
      JOptionPane.showMessageDialog(null,
          "Entrada de " + qtd + " unidades registrada para '" + item.getNome() + "'.",
          "Entrada de Estoque",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Item (ID: " + id + ") não encontrado para registrar entrada.",
          "Erro",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean registrarSaida(int id, int qtd, String resp) {
    ItemEstoque item = buscarItemPorId(id);
    if (item != null) {
      boolean sucesso = item.darSaida(qtd, resp);
      if (sucesso) {
        // Delegação e Regra de Negócio: Se ficou abaixo do mínimo após a saída, alerta!
        if (item.isAbaixoMinimo() && this.notificador != null) {
          this.notificador.enviarAlertaEstoque(item);
        }
        return true;
      } else {
        JOptionPane.showMessageDialog(null,
            "Quantidade insuficiente em estoque para a saída de '" + item.getNome() + "'.",
            "Saída Negada",
            JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    JOptionPane.showMessageDialog(null,
        "Item (ID: " + id + ") não encontrado para registrar saída.",
        "Erro",
        JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public boolean reservarParaProced(Agendamento ag) {
    if (ag != null) {
      // Lógica simulada de reserva baseada no agendamento
      JOptionPane.showMessageDialog(null,
          "Recursos de estoque reservados com sucesso para o procedimento: " + ag.getTipo(),
          "Reserva Confirmada",
          JOptionPane.INFORMATION_MESSAGE);
      return true;
    }
    return false;
  }

  public List<ItemEstoque> listarControlados() {
    List<ItemEstoque> controlados = new ArrayList<>();
    for (ItemEstoque item : itens) {
      if (item.isControlado()) {
        controlados.add(item);
      }
    }
    return controlados;
  }

  public void alertarVencimentos() {
    int itensVencidos = 0;
    for (ItemEstoque item : itens) {
      if (item.isVencido()) {
        itensVencidos++;
        if (this.notificador != null) {
          this.notificador.enviarAlerta("Administrador",
              "Atenção: O lote " + item.getLote() + " do item '" + item.getNome() + "' está vencido!");
        }
      }
    }

    if (itensVencidos == 0) {
      JOptionPane.showMessageDialog(null,
          "Nenhum item vencido detectado no estoque.",
          "Verificação de Validade",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void gerarRelatorioRastreab() {
    List<ItemEstoque> controlados = listarControlados();
    String mensagem = "=== RELATÓRIO DE RASTREABILIDADE (CONTROLADOS) ===\n";

    for (ItemEstoque item : controlados) {
      mensagem += "- " + item.getNome() + " | Lote: " + item.getLote() + " | Qtd: " + item.getQuantidade() + "\n";
    }

    if (controlados.isEmpty()) {
      mensagem += "Nenhum medicamento controlado em estoque.";
    }

    JOptionPane.showMessageDialog(null, mensagem, "Rastreabilidade", JOptionPane.INFORMATION_MESSAGE);
  }

  public List<ItemEstoque> getItens() {
    return itens;
  }

  public void exibir() {
    String mensagem = "=== GESTÃO DE ESTOQUE ===\n"
        + "Total de Itens Cadastrados: " + this.itens.size() + "\n"
        + "Itens Controlados: " + listarControlados().size() + "\n"
        + "Sistema de Notificação: " + (this.notificador != null ? "Ativo" : "Inativo");

    JOptionPane.showMessageDialog(null, mensagem, "Resumo do Estoque", JOptionPane.INFORMATION_MESSAGE);
  }
}