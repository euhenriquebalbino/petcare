package com.petcare.clinico;

import com.petcare.usuario.Veterinario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Vacina extends RegistroClinico {

    private String nomeVacina;
    private String dataReforco;
    private String lote;
    private String fabricante;

    public Vacina(int id, String data, String descricao, Veterinario veterinario, String nomeVacina) {
        super(id, data, descricao, veterinario);
        this.nomeVacina = nomeVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getDataReforco() {
        return dataReforco;
    }

    public void setDataReforco(String dataReforco) {
        if (dataReforco != null && !dataReforco.trim().isEmpty()) {
            this.dataReforco = dataReforco;
        } else {
            JOptionPane.showMessageDialog(null, "A data de reforço não pode ser vazia.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public boolean precisaReforco() {
        if (this.dataReforco == null || this.dataReforco.trim().isEmpty()) {
            return false;
        }

        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataDoReforco = LocalDate.parse(this.dataReforco, formatador);
            LocalDate hoje = LocalDate.now();

            return dataDoReforco.isBefore(hoje) || dataDoReforco.isEqual(hoje);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar a data de reforço. Use o formato dd/MM/yyyy.",
                    "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public void exibir() {
        super.exibir();

        String statusReforco = precisaReforco() ? "SIM (Atrasada ou Vencendo hoje)" : "NÃO";

        String mensagem = "=== DADOS DA VACINA ===\n"
                + "Nome da Vacina: " + this.nomeVacina + "\n"
                + "Fabricante: " + (this.fabricante != null ? this.fabricante : "Não informado") + "\n"
                + "Lote: " + (this.lote != null ? this.lote : "Não informado") + "\n"
                + "Data de Reforco: " + (this.dataReforco != null ? this.dataReforco : "Não agendado") + "\n"
                + "Precisa de Reforço Agora? " + statusReforco;

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes da Vacinação", JOptionPane.INFORMATION_MESSAGE);
    }
}