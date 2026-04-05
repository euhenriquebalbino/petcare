package com.petcare.animal;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Animal {
    private int id;
    private String nome, especie, raca, dataNascimento;
    private double peso;
    private Tutor t1 = new Tutor();
    private HistoricoClinico hc1 = new HistoricoClinico();

    public Animal(int id, String nome, String especie, String raca, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.t1 = tutor; 
    }

    public String getNome() { return nome; }
    public Tutor getTutor() { return t1; }
    public HistoricoClinico getHistorico() { return hc1; }
    
    public void setPeso(double peso) {
        if (peso > 0) this.peso = peso;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int calcularIdade() {
        if (this.dataNascimento == null) return 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nasc = LocalDate.parse(this.dataNascimento, fmt);
        return Period.between(nasc, LocalDate.now()).getYears();
    }

    public void exibir() {
        String mensagem = "DADOS DO ANIMAL:\n" +
                "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Espécie: " + especie + " (" + raca + ")\n" +
                "Idade: " + calcularIdade() + " anos\n" +
                "Tutor: " + (t1 != null ? t1.getNome() : "Não cadastrado");
        
        JOptionPane.showMessageDialog(null, mensagem);
    }
}