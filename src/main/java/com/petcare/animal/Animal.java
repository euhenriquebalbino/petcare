//trabalho realizado por: Luan Oliveira
package com.petcare.animal;

import com.petcare.usuario.Tutor;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Animal {

  private int id;
  private String nome;
  private String especie;
  private String raca;
  private String dataNascimento;
  private double peso;
  private Tutor tutor;
  private HistoricoClinico historico;

  public Animal(int id, String nome, String especie, String raca, Tutor tutor) {
    this.id = id;
    this.nome = nome;
    this.especie = especie;
    this.raca = raca;

    if (tutor != null) {
      this.tutor = tutor;
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro: Todo animal deve pertencer a um tutor válido.",
          "Erro de Validação",
          JOptionPane.ERROR_MESSAGE);
    }

    this.historico = new HistoricoClinico(this.id);
  }

  public int calcularIdade() {
    if (this.dataNascimento == null || !this.dataNascimento.contains("/")) {
      return 0;
    }

    String[] partes = this.dataNascimento.split("/");

    if (partes.length == 3) {
      int diaNasc = Integer.parseInt(partes[0]);
      int mesNasc = Integer.parseInt(partes[1]);
      int anoNasc = Integer.parseInt(partes[2]);

      LocalDate hoje = LocalDate.now();
      int anoAtual = hoje.getYear();
      int mesAtual = hoje.getMonthValue();
      int diaAtual = hoje.getDayOfMonth();

      int idade = anoAtual - anoNasc;

      if (mesAtual < mesNasc || (mesAtual == mesNasc && diaAtual < diaNasc)) {
        idade--;
      }

      if (idade > 0) {
        return idade;
      }
    }
    return 0;
  }

  public void exibir() {
    String idade = (calcularIdade() > 0) ? calcularIdade() + " ano(s)" : "Menos de 1 ano / Não informada";
    String nomeTutor = (this.tutor != null) ? this.tutor.getNome() : "Sem tutor";

    String mensagem = "ANIMAL:\n"
        + "ID: " + this.id + "\n"
        + "Nome: " + this.nome + "\n"
        + "Espécie/Raça: " + this.especie + " - " + this.raca + "\n"
        + "Idade: " + idade + "\n"
        + "Peso: " + this.peso + " kg\n"
        + "Tutor: " + nomeTutor;

    JOptionPane.showMessageDialog(null, mensagem, "Dados do Animal", JOptionPane.INFORMATION_MESSAGE);
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Tutor getTutor() {
    return tutor;
  }

  public HistoricoClinico getHistorico() {
    return historico;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    if (peso > 0) {
      this.peso = peso;
    } else {
      JOptionPane.showMessageDialog(null,
          "Erro: O peso deve ser maior que zero.",
          "Valor Inválido",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}
