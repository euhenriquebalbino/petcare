package com.petcare.usuario;

import com.petcare.animal.Animal;
import com.petcare.financeiro.Fatura;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Tutor extends Usuario {
  private String cpf, telefone, endereco;
  private List<Animal> animais;

  public Tutor(int id, String nome, String email, String senha, String cpf, String telefone) {
    super(id, nome, email, senha, "TUTOR");
    this.cpf = cpf;
    this.telefone = telefone;
    this.animais = new ArrayList<>();
  }

  public String getCpf() {
    return cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public List<Animal> getAnimais() {
    return animais;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void adicionarAnimal(Animal animal) {
    if (animal != null) {
      this.animais.add(animal);
      JOptionPane.showMessageDialog(null, "Animal '" + animal.getNome() + "' vinculado ao tutor " + this.getNome());
    } else {
      JOptionPane.showMessageDialog(null, "Erro: Não é possível adicionar um animal nulo.");
    }
  }

  public void verHistoricoAnimal(int id) {
    for (Animal animal : animais) {
      if (animal.getId() == id) {
        JOptionPane.showMessageDialog(null, "Acessando histórico clínico do animal: " + animal.getNome());
        return;
      }
    }
    JOptionPane.showMessageDialog(null, "Animal não encontrado para o ID " + id);
  }

  public List<Fatura> verFaturas() {
    JOptionPane.showMessageDialog(null, "Buscando faturas do tutor " + this.getNome() + "...");
    return new ArrayList<>();
  }

  public Animal buscarAnimal(String nome) {
    for (Animal animal : animais) {
      if (animal.getNome().equalsIgnoreCase(nome)) {
        return animal;
      }
    }
    JOptionPane.showMessageDialog(null, "Animal com nome '" + nome + "' não encontrado.");
    return null;
  }

  @Override
  public void exibir() {
    super.exibir();
    JOptionPane.showMessageDialog(null, 
      "CPF: " + this.cpf
      + "\nTelefone: " + this.telefone
      + "\nEndereço: " + (this.endereco != null ? this.endereco : "Não cadastrado")
      + "\nTotal de Animais Cadastrados: " + this.animais.size()
      + "\n========================");
  }
}
