package com.petcare.animal;
import java.util.List;
import javax.swing.JOptionPane;

public class Cirurgia {
    private int idAnimal;
    private List<Consulta> consultas = new ArrayList<>();
    private List<Vacina> vacinas = new ArrayList<>();
    private List<Cirurgia> cirurgias = new ArrayList<>();
    private List<Exame> exames = new ArrayList<>();
    private List<Tratamento> tratamentos = new ArrayList<>();
    private boolean finalizado = false;
    //.
    private String relatorioMedico;
    private String prescricao;
    private int duracaoHoras;
    
    public Cirurgia(int idAnimal, int duracaoHoras) {
        this.idAnimal = idAnimal;
        if (duracaoHoras < 2) {
            this.duracaoHoras = 2;
        } else {
            this.duracaoHoras = duracaoHoras;
        }
    }

    public void finalizarProcedimento(String relatorio, String prescricao) {
        if (relatorio == null || relatorio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro: Relatório médico é obrigatório!");
            return;
        }
        this.relatorioMedico = relatorio;
        this.prescricao = prescricao;
        this.finalizado = true;
        JOptionPane.showMessageDialog(null, "Cirurgia finalizada e bloqueada para edições.");
    }

    public void adicionarExame(Exame novoExame) {
        if (finalizado) {
            JOptionPane.showMessageDialog(null, "Erro: Histórico finalizado não permite alterações.");
        } else {
            this.exames.add(novoExame);
        }
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void exibirResumo() {
        String status = finalizado ? "Finalizada (Bloqueada)" : "Em aberto";
        JOptionPane.showMessageDialog(null, "Resumo da Cirurgia:\n"
                + "ID Animal: " + idAnimal
                + "\nDuração: " + duracaoHoras
                + "h\nStatus: " + status
                + "\nExames anexados: " + exames.size());
    }
    
}
