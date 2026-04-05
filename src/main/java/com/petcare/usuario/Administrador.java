package com.petcare.usuario;

import com.petcare.financeiro.Relatorio;
import com.petcare.auditoria.LogAuditoria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Administrador extends Usuario {
  private int nivelAcesso;
  private String departamento;

  public Administrador(int id, String nome, String email, String senha) {
    super(id, nome, email, senha, "ADMINISTRADOR");
    this.nivelAcesso = 1;
    this.departamento = "Diretoria Geral";
  }

  public boolean excluirRegistro(int id, String tipo) {
    JOptionPane.showMessageDialog(null, "Solicitação de exclusão recebida.");
    JOptionPane.showMessageDialog(null, "Buscando registro ID: " + id + " no módulo: " + tipo);
    if (tipo != null && !tipo.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Registro " + tipo + " (ID: " + id + ") excluído com sucesso!");
      return true;
    }
    JOptionPane.showMessageDialog(null, "Falha ao excluir: tipo inválido.");
    return false;
  }

  public void ajustarEstoque(String item, int qtd) {
    JOptionPane.showMessageDialog(null, "Ajustando estoque do item " + item + " em " + qtd + " unidades.");
  }

  public Relatorio gerarRelatorio(int mes, int ano) {
    JOptionPane.showMessageDialog(null, "Administrador " + this.getNome() + " solicitou relatório de " + mes + "/" + ano);
    Relatorio relatorio = new Relatorio(mes, ano);
    relatorio.gerar();
    return relatorio;
  }

  public void gerenciarUsuario(Usuario usuario) {
    if (usuario != null) {
      JOptionPane.showMessageDialog(null, "Gerenciando conta do usuário: " + usuario.getNome() + " (Perfil: " + usuario.getPerfil() + ")");

      if (usuario.isAtivo()) {
        usuario.desativar();
        JOptionPane.showMessageDialog(null, "Status alterado: Usuário desativado com sucesso pelo Administrador.");
      } else {
        JOptionPane.showMessageDialog(null, "Atenção: O usuário já encontra-se inativo.");
      }
    }
  }

  public List<LogAuditoria> visualizarLogs() {
    JOptionPane.showMessageDialog(null, "Acessando painel de auditoria...");
    List<LogAuditoria> logs = new ArrayList<>();
    JOptionPane.showMessageDialog(null, "Logs recuperados com sucesso.");
    return logs;
  }

  @Override
  public void exibir() {
      super.exibir(); 
      JOptionPane.showMessageDialog(null, 
        "Nível de Acesso: " + this.nivelAcesso
        + "\nDepartamento: " + this.departamento);
  }
}
