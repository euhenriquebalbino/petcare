package com.petcare.usuario;

import com.petcare.animal.Animal;
import com.petcare.agendamento.Agendamento;

import javax.swing.JOptionPane;

public class Recepcionista extends Usuario {
  private String ramal, turno;

  public Recepcionista(int id, String nome, String email, String senha, String ramal) {
    super(id, nome, email, "", "RECEPCIONISTA");
    this.ramal = ramal;
  }

  public void cadastrarTutor(Tutor tutor) {
    if (tutor != null) {
      JOptionPane.showMessageDialog(null,
          "Tutor '" + tutor.getNome() + "' cadastrado com sucesso no sistema.",
          "Cadastro de Tutor",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro: Dados do tutor inválidos.",
          "Erro no Cadastro",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public void cadastrarAnimal(Animal animal) {
    if (animal != null) {
      JOptionPane.showMessageDialog(null,
        "Animal '" + animal.getNome() + "' cadastrado com sucesso.",
        "Cadastro de Animal",
        JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
        "Erro: Dados do animal inválidos.",
        "Erro no Cadastro",
        JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean agendarConsulta(Agendamento agendamento) {
    if (agendamento != null) {
      JOptionPane.showMessageDialog(null,
          "Consulta agendada com sucesso no sistema!",
          "Agendamento Confirmado",
          JOptionPane.INFORMATION_MESSAGE);
      return true;
    }

    JOptionPane.showMessageDialog(null,
        "Erro ao tentar agendar a consulta.",
        "Falha no Agendamento",
        JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public void cancelarConsulta(int id) {
    JOptionPane.showMessageDialog(null,
        "A consulta de ID " + id + " foi cancelada.",
        "Cancelamento de Consulta",
        JOptionPane.WARNING_MESSAGE);
  }

  @Override
  public void exibir() {
    super.exibir();
    JOptionPane.showMessageDialog(null, "Ramal: " + ramal + " | Turno: " + turno);
  }
}
