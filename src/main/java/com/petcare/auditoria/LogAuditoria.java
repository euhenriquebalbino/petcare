//trabalho realizado por: Lorenzo Silote
package com.petcare.auditoria;

import com.petcare.usuario.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LogAuditoria {

  private int id;
  private String dataHora;
  private Usuario usuario;
  private String acao;
  private String entidadeAfetada;
  private int idEntidade;
  private String ipOrigem;

  public LogAuditoria(Usuario usuario, String acao, String entidadeAfetada) {
    this.usuario = usuario;
    this.acao = acao;
    this.entidadeAfetada = entidadeAfetada;
    this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  }

  public void registrar() {
    if (this.usuario != null && this.acao != null) {
      String mensagem = "Registro de Auditoria Salvo:\n"
          + "Data/Hora: " + this.dataHora + "\n"
          + "Usuário: " + this.usuario.getNome() + "\n"
          + "Ação: " + this.acao;
      JOptionPane.showMessageDialog(null, mensagem, "Auditoria", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Falha ao registrar: Usuário ou ação inválidos.", "Erro",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getAcao() {
    return acao;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public String getDataHora() {
    return dataHora;
  }

  public List<LogAuditoria> buscarPorUsuario(Usuario u) {
    return new ArrayList<>();
  }

  public List<LogAuditoria> buscarPorEntidade(String e) {
    return new ArrayList<>();
  }

  public void exibir() {
    String nomeUsuario = (this.usuario != null) ? this.usuario.getNome() : "Desconhecido";

    String mensagem = "=== LOG DE AUDITORIA ===\n"
        + "Data/Hora: " + this.dataHora + "\n"
        + "Usuário: " + nomeUsuario + "\n"
        + "Ação: " + this.acao + "\n"
        + "Entidade Afetada: " + this.entidadeAfetada;

    JOptionPane.showMessageDialog(null, mensagem, "Detalhes do Log", JOptionPane.INFORMATION_MESSAGE);
  }
}