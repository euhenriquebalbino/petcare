//trabalho realizado por: Henrique Balbino
package com.petcare.usuario;

import com.petcare.financeiro.Relatorio;

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
    if (tipo != null && !tipo.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Registro do tipo '" + tipo + "' (ID: " + id + ") excluído com sucesso.",
          "Exclusão Concluída", JOptionPane.INFORMATION_MESSAGE);
      return true;
    }
    JOptionPane.showMessageDialog(null, "Falha ao excluir: tipo inválido.", "Erro de Exclusão",
        JOptionPane.ERROR_MESSAGE);
    return false;
  }

  public void ajustarEstoque(String item, int qtd) {
    JOptionPane.showMessageDialog(null,
        "Estoque do item '" + item + "' ajustado.\nNova quantidade: " + qtd + " unidades.", "Ajuste de Estoque",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public Relatorio gerarRelatorio(int mes, int ano) {
    JOptionPane.showMessageDialog(null,
        "Administrador " + this.getNome() + " solicitou relatório de " + mes + "/" + ano, "Gerando Relatório",
        JOptionPane.INFORMATION_MESSAGE);
    Relatorio relatorio = new Relatorio(mes, ano);
    relatorio.gerar();
    return relatorio;
  }

  public void gerenciarUsuario(Usuario u) {
    if (u != null) {
      if (u.isAtivo()) {
        u.desativar();
        JOptionPane.showMessageDialog(null, "Status alterado: Usuário desativado com sucesso.", "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "Atenção: O usuário já encontra-se inativo.", "Aviso",
            JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Erro: Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  @Override
  public void exibir() {
    super.exibir();

    String mensagem = "DADOS DO ADMINISTRADOR:\n"
        + "Nível de Acesso: " + this.nivelAcesso + "\n"
        + "Departamento: " + this.departamento;

    JOptionPane.showMessageDialog(null, mensagem, "Informações do Perfil", JOptionPane.INFORMATION_MESSAGE);
  }

  public int getNivelAcesso() {
    return nivelAcesso;
  }

  public void setNivelAcesso(int nivelAcesso) {
    if (nivelAcesso > 0) {
      this.nivelAcesso = nivelAcesso;
    } else {
      JOptionPane.showMessageDialog(null, "Erro: Nível de acesso inválido.", "Erro de Validação",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    if (departamento != null && !departamento.trim().isEmpty()) {
      this.departamento = departamento;
    }
  }
}
