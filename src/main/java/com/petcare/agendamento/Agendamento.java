//trabalho realizado por: Lorenzo Silote
package com.petcare.agendamento;

import com.petcare.animal.Animal;
import com.petcare.usuario.Veterinario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Agendamento {

  private int id;
  private String dataHora;
  private String tipo;
  private String status;
  private Animal animal;
  private Veterinario veterinario;
  private String sala;
  private Notificador notificador;
  private List<String> historico;

  public Agendamento(int id, String dt, String tipo, Animal animal, Veterinario vet, Notificador notif) {
    this.id = id;
    this.dataHora = dt;
    this.tipo = tipo;
    this.animal = animal;
    this.veterinario = vet;
    this.notificador = notif;
    this.status = "AGENDADO";
    this.historico = new ArrayList<>();
    this.historico.add("Agendamento criado em " + dt);
  }

  public boolean validarHorario() {
    if (this.dataHora != null && this.dataHora.contains(" ") && this.dataHora.contains(":")) {
      String[] partes = this.dataHora.split(" ");
      String[] tempo = partes[1].split(":");

      int hora = Integer.parseInt(tempo[0]);

      if (hora >= 8 && hora <= 18) {
        return true;
      }
    }
    JOptionPane.showMessageDialog(null, "Erro (RN04): O horário de funcionamento é das 08h às 18h.", "Horário Inválido",
        JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public boolean validarVeterinario() {
    if (this.veterinario != null && this.veterinario.isDisponivel()) {
      return true;
    }
    JOptionPane.showMessageDialog(null, "Erro (RN03): O veterinário selecionado não está disponível no momento.",
        "Indisponível", JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public boolean reservarRecursos() {
    if (this.sala != null && !this.sala.trim().isEmpty()) {
      this.historico.add("Recursos reservados. Sala: " + this.sala);
      return true;
    }
    return false;
  }

  public boolean agendar() {
    if (validarHorario() && validarVeterinario()) {
      this.status = "AGENDADO";
      this.historico.add("Status alterado para AGENDADO");
      notificarTutor();
      return true;
    }
    this.status = "CANCELADO";
    return false;
  }

  public void cancelar(String motivo) {
    this.status = "CANCELADO";
    this.historico.add("Cancelado. Motivo: " + motivo);
    if (this.notificador != null) {
      this.notificador.enviarCancelamento(this);
    }
  }

  public void reagendar(String novaData) {
    this.dataHora = novaData;
    if (validarHorario()) {
      this.status = "AGENDADO";
      this.historico.add("Reagendado para: " + novaData);
      if (this.notificador != null) {
        this.notificador.enviarReagendamento(this);
      }
    }
  }

  public void notificarTutor() {
    if (this.notificador != null) {
      this.notificador.enviarConfirmacao(this);
    }
  }

  public String getStatus() {
    return status;
  }

  public List<String> getHistorico() {
    return historico;
  }

  public String getDataHora() {
    return dataHora;
  }

  public String getTipo() {
    return tipo;
  }

  public void exibir() {
    String nomeVet = (this.veterinario != null) ? this.veterinario.getNome() : "Não definido";
    String nomeAnimal = (this.animal != null) ? this.animal.getNome() : "Não definido";

    String mensagem = "AGENDAMENTO:\n"
        + "Data/Hora: " + this.dataHora + "\n"
        + "Tipo: " + this.tipo + "\n"
        + "Status: " + this.status + "\n"
        + "Paciente: " + nomeAnimal + "\n"
        + "Veterinário: " + nomeVet + "\n"
        + "Sala: " + (this.sala != null ? this.sala : "Não alocada");

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes do Agendamento", JOptionPane.INFORMATION_MESSAGE);
  }
}
