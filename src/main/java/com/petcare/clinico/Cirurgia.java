package com.petcare.clinico;

import com.petcare.usuario.Veterinario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cirurgia extends RegistroClinico {

    private int duracao;
    private String sala;
    private List<String> equipe;
    private String anestesia;
    private List<String> medicamentos;

    public Cirurgia(int id, String data, String descricao, Veterinario veterinario, String sala) {
        super(id, data, descricao, veterinario);
        this.sala = sala;
        this.equipe = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
        this.duracao = 120;
    }

    public void adicionarMedicamento(String medicamento) {
        if (medicamento != null && !medicamento.trim().isEmpty()) {
            this.medicamentos.add(medicamento);
        } else {
            JOptionPane.showMessageDialog(null, "O nome do medicamento não pode ser vazio.", "Erro",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean validarRecursos() {
        if (this.sala != null && !this.sala.trim().isEmpty() && !this.equipe.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Recursos validados com sucesso.", "Validação",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Falha na validação de recursos.", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public void exibir() {
        super.exibir();

        String mensagem = "=== DADOS DA CIRURGIA ===\n"
                + "Sala: " + this.sala + "\n"
                + "Duração: " + this.duracao + " min\n"
                + "Tamanho da Equipe: " + this.equipe.size() + "\n"
                + "Medicamentos: " + this.medicamentos.size() + "\n"
                + "Anestesia: " + (this.anestesia != null ? this.anestesia : "Não definida");

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (duracao >= 120) {
            this.duracao = duracao;
        } else {
            JOptionPane.showMessageDialog(null, "A duração não pode ser inferior a 120 minutos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public List<String> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<String> equipe) {
        if (equipe != null && !equipe.isEmpty()) {
            this.equipe = equipe;
        } else {
            JOptionPane.showMessageDialog(null, "A lista de equipe não pode ser vazia.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getAnestesia() {
        return anestesia;
    }

    public void setAnestesia(String anestesia) {
        this.anestesia = anestesia;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }
}