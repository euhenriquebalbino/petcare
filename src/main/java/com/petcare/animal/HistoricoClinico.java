package com.petcare.animal;

import com.petcare.clinico.Cirurgia;
import com.petcare.clinico.Consulta;
import com.petcare.clinico.Exame;
import com.petcare.clinico.Vacina;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HistoricoClinico {

  private int idAnimal;
  private List<Consulta> consultas;
  private List<Vacina> vacinas;
  private List<Cirurgia> cirurgias;
  private List<Exame> exames;
  private List<String> tratamentos;
  private boolean finalizado;

  public HistoricoClinico(int idAnimal) {
    this.idAnimal = idAnimal;
    this.consultas = new ArrayList<>();
    this.vacinas = new ArrayList<>();
    this.cirurgias = new ArrayList<>();
    this.exames = new ArrayList<>();
    this.tratamentos = new ArrayList<>();
    this.finalizado = false;
  }

  private void exibirErroRN07() {
    JOptionPane.showMessageDialog(null,
        "Erro: Histórico clínico finalizado. Não é possível adicionar novos registros.",
        "Acesso Negado",
        JOptionPane.ERROR_MESSAGE);
  }

  public void adicionarConsulta(Consulta c) {
    if (this.finalizado) {
      exibirErroRN07();
    } else if (c != null) {
      this.consultas.add(c);
      JOptionPane.showMessageDialog(null, "Consulta adicionada com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void adicionarVacina(Vacina v) {
    if (this.finalizado) {
      exibirErroRN07();
    } else if (v != null) {
      this.vacinas.add(v);
      JOptionPane.showMessageDialog(null, "Vacina adicionada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void adicionarCirurgia(Cirurgia c) {
    if (this.finalizado) {
      exibirErroRN07();
    } else if (c != null) {
      this.cirurgias.add(c);
      JOptionPane.showMessageDialog(null, "Cirurgia adicionada com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void adicionarExame(Exame e) {
    if (this.finalizado) {
      exibirErroRN07();
    } else if (e != null) {
      this.exames.add(e);
      JOptionPane.showMessageDialog(null, "Exame adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void adicionarTratamento(String t) {
    if (this.finalizado) {
      exibirErroRN07();
    } else if (t != null && !t.trim().isEmpty()) {
      this.tratamentos.add(t);
      JOptionPane.showMessageDialog(null, "Tratamento adicionado com sucesso.", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public void finalizar() {
    if (!this.finalizado) {
      this.finalizado = true;
      JOptionPane.showMessageDialog(null,
          "Histórico clínico finalizado com sucesso.",
          "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "O histórico já está finalizado.",
          "Aviso",
          JOptionPane.WARNING_MESSAGE);
    }
  }

  public boolean isFinalizado() {
    return finalizado;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public List<Vacina> getVacinas() {
    return vacinas;
  }

  public void exibir() {
    String status = this.finalizado ? "Finalizado" : "Em Aberto";
    String mensagem = "=== HISTÓRICO CLÍNICO ===\n"
        + "ID Animal: " + this.idAnimal + "\n"
        + "Status: " + status + "\n"
        + "Consultas: " + this.consultas.size() + "\n"
        + "Vacinas: " + this.vacinas.size() + "\n"
        + "Cirurgias: " + this.cirurgias.size() + "\n"
        + "Exames: " + this.exames.size() + "\n"
        + "Tratamentos: " + this.tratamentos.size();

    JOptionPane.showMessageDialog(null, mensagem, "Resumo do Histórico", JOptionPane.INFORMATION_MESSAGE);
  }
}