//trabalho realizado por: Henrique Balbinos
package com.petcare.usuario;

import com.petcare.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Tutor extends Usuario {

  private String cpf;
  private String telefone;
  private String endereco;
  private List<Animal> pets;

  public Tutor(int id, String nome, String email, String senha, String cpf, String telefone, String endereco) {
    super(id, nome, email, senha, "TUTOR");
    this.cpf = cpf;
    this.telefone = telefone;
    this.endereco = endereco;
    this.pets = new ArrayList<>();
  }

  public void adicionarPet(Animal pet) {
    if (pet != null) {
      this.pets.add(pet);
      JOptionPane.showMessageDialog(null, "Pet adicionado com sucesso ao tutor " + this.getNome() + ".", "Sucesso",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Dados do pet inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void removerPet(Animal pet) {
    if (pet != null && this.pets.contains(pet)) {
      this.pets.remove(pet);
      JOptionPane.showMessageDialog(null, "Pet removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Pet não encontrado na lista deste tutor.", "Erro",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public List<Animal> getPets() {
    return pets;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  @Override
  public void exibir() {
    super.exibir();

    String mensagem = "=== DADOS DO TUTOR ===\n"
        + "Nome: " + this.getNome() + "\n"
        + "CPF: " + this.cpf + "\n"
        + "Telefone: " + this.telefone + "\n"
        + "Endereço: " + this.endereco + "\n"
        + "Quantidade de Pets: " + this.pets.size();

    JOptionPane.showMessageDialog(null, mensagem, "Perfil do Tutor", JOptionPane.INFORMATION_MESSAGE);
  }
}