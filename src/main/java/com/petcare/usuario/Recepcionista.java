//trabalho realizado por: Henrique Balbino
package com.petcare.usuario;

import com.petcare.agendamento.Agendamento;
import com.petcare.animal.Animal;

import javax.swing.JOptionPane;

public class Recepcionista extends Usuario {

  private String ramal;
  private String turno;

  public Recepcionista(int id, String nome, String email, String senha, String ramal) {
    super(id, nome, email, senha, "RECEPCIONISTA");
    this.ramal = ramal;
    this.turno = "Manhã";
  }

  public void cadastrarTutor(Tutor t) {
    if (t != null) {
      JOptionPane.showMessageDialog(null, "Tutor '" + t.getNome() + "' cadastrado com sucesso.", "Cadastro",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Erro: Dados do tutor inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void cadastrarAnimal(Animal a) {
    if (a != null) {
      JOptionPane.showMessageDialog(null, "Animal '" + a.getNome() + "' cadastrado com sucesso.", "Cadastro",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Erro: Dados do animal inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean agendarConsulta(Agendamento ag) {
    if (ag != null) {
      JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso.", "Agendamento",
          JOptionPane.INFORMATION_MESSAGE);
      return true;
    }
    JOptionPane.showMessageDialog(null, "Erro ao agendar a consulta.", "Erro", JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public void cancelarConsulta(int id) {
    JOptionPane.showMessageDialog(null, "Consulta de ID " + id + " cancelada.", "Cancelamento",
        JOptionPane.WARNING_MESSAGE);
  }

  public Tutor buscarTutor(String termo) {
    JOptionPane.showMessageDialog(null, "Buscando tutor: " + termo, "Busca", JOptionPane.INFORMATION_MESSAGE);
    return null;
  }

  public Animal buscarAnimal(String termo) {
    JOptionPane.showMessageDialog(null, "Buscando animal: " + termo, "Busca", JOptionPane.INFORMATION_MESSAGE);
    return null;
  }

  @Override
  public void exibir() {
    super.exibir();

    String mensagem = "=== DADOS DA RECEPCIONISTA ===\n"
        + "Ramal: " + this.ramal + "\n"
        + "Turno: " + this.turno;

    JOptionPane.showMessageDialog(null, mensagem, "Perfil", JOptionPane.INFORMATION_MESSAGE);
  }

  public String getRamal() {
    return ramal;
  }

  public void setRamal(String ramal) {
    this.ramal = ramal;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }
}