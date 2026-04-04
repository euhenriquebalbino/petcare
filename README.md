# 🐾 Sistema Integrado PetCare (SIP)

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO), com o objetivo de modelar e implementar um sistema para uma clínica veterinária.


## 📖 Descrição

O Sistema Integrado PetCare (SIP) tem como objetivo gerenciar os principais processos de uma clínica veterinária, incluindo:

- Cadastro de usuários (administrador, veterinário, recepcionista e tutor)
- Gestão de animais e histórico clínico
- Agendamento de consultas, exames e cirurgias
- Controle de estoque de medicamentos
- Emissão de faturas e relatórios
- Registro de auditoria


## 🧠 Conceitos de POO aplicados

Este projeto utiliza os principais pilares da Programação Orientada a Objetos:

- **Herança** → reutilização de código entre classes (ex: Usuario → Veterinario)
- **Encapsulamento** → proteção de atributos com validações
- **Composição** → relação entre objetos (ex: Animal possui Histórico)
- **Delegação** → responsabilidades distribuídas (ex: Agendamento → Notificador)


## 🗂️ Estrutura do Projeto

├── agendamento/ <br>
│⠀⠀⠀├── Notificador.java <br>
│⠀⠀⠀└── Agendamento.java <br>
├── animal/ <br>
│⠀⠀⠀├── Animal.java <br>
│⠀⠀⠀└── HistoricoClinico.java <br>
├── auditoria/ <br>
│⠀⠀⠀└── LogAuditoria.java <br>
├── clinico/ <br>
│⠀⠀⠀├── RegistroClinico.java <br>
│⠀⠀⠀├── Consulta.java <br>
│⠀⠀⠀├── Cirurgia.java <br>
│⠀⠀⠀├── Exame.java <br>
│⠀⠀⠀└── Vacina.java <br>
├── estoque/ <br>
│⠀⠀⠀├── ItemEstoque.java <br>
│⠀⠀⠀└── Estoque.java <br>
├── financeiro/ <br>
│⠀⠀⠀├── Fatura.java <br>
│⠀⠀⠀└── Relatorio.java <br>
├── main/ <br>
│⠀⠀⠀└── Main.java <br>
└── usuario/ <br>
⠀⠀⠀⠀├── Usuario.java <br>
⠀⠀⠀⠀├── Administrador.java <br>
⠀⠀⠀⠀├── Veterinario.java <br>
⠀⠀⠀⠀├── Recepcionista.java <br>
⠀⠀⠀⠀└── Tutor.java <br>


## 👥 Integrantes do grupo

- [Henrique de Paula Balbino](https://github.com/euhenriquebalbino)
- [Lorenzo Silote Barbosa Barros](https://github.com/luanaraujo2)
- [Luan Araujo de Oliveira](https://github.com/PedroComper)
- [Pedro Lucas Oliveira Comper](https://github.com/silotelz)

## ⚠️ Observações

Este projeto tem fins acadêmicos e foi desenvolvido como parte de um trabalho avaliativo.