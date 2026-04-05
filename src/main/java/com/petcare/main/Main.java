package com.petcare.main;

import com.petcare.usuario.*;
import com.petcare.animal.*;
import com.petcare.agendamento.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        List<Agendamento> listaAgendamentos = new ArrayList<>();
        Veterinario vet = new Veterinario(10, "Dr. Silva", "silva@vet.com", "v123", "CRMV-123", "Geral");
        Notificador notif = new Notificador("SMS", "9999-9999");

        while (true) {
            String[] opcoesMenu = {"Agendar", "Ver Agendamentos", "Sair"};
            int selecao = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Sistema PetCare",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);

            if (selecao == 2 || selecao == -1) break;

            switch (selecao) {
                case 0: // Agendar
                    String nomeTutor = JOptionPane.showInputDialog("Nome do Tutor:");
                    if (nomeTutor == null) break;
                    Tutor tutor = new Tutor(1, nomeTutor, "email@pet.com", "123", "000.000.000-00", "9999-9999", "Rua A");

                    String nomePet = JOptionPane.showInputDialog("Nome do Pet:");
                    if (nomePet == null) break;
                    Animal pet = new Animal(1, nomePet, "Cão", "SRD", tutor);

                    // --- SELETOR DE DATA E HORA CUSTOMIZADO ---
                    // Criamos um Spinner configurado para data e hora
                    SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
                    JSpinner spinner = new JSpinner(model);
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy HH:mm");
                    spinner.setEditor(editor);

                    Object[] mensagem = {
                        "Selecione a Data e Hora do Agendamento:", spinner,
                        "\n(Horário comercial: 08:00 às 18:00)"
                    };

                    int res = JOptionPane.showConfirmDialog(null, mensagem, "Calendário PetCare", JOptionPane.OK_CANCEL_OPTION);
                    
                    if (res == JOptionPane.OK_OPTION) {
                        Date dataSelecionada = (Date) spinner.getValue();
                        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        String dataFormatada = formatador.format(dataSelecionada);

                        Agendamento novoAg = new Agendamento(100 + listaAgendamentos.size(), dataFormatada, "Consulta", pet, vet, notif);
                        
                        if (novoAg.validarHorario()) {
                            novoAg.agendar();
                            listaAgendamentos.add(novoAg);
                            JOptionPane.showMessageDialog(null, "Agendamento confirmado para: " + dataFormatada);
                        }
                    }
                    break;

                case 1: // Ver Agendamentos
                    if (listaAgendamentos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum agendamento.");
                    } else {
                        for (Agendamento a : listaAgendamentos) {
                            a.exibir();
                        }
                    }
                    break;
            }
        }
    }
}