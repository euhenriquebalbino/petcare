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

  }

  public void cadastrarAnimal(Animal animal) {

  }

  public boolean agendarConsulta(Agendamento agendamento) {
    return true; 
  }

  public void cancelarConsulta(int id) {

  }

  @Override
  public void exibir() {
    super.exibir(); 
    JOptionPane.showMessageDialog(null, "Ramal: " + ramal + " | Turno: " + turno); 
  }
}
