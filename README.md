# DesafioBugBank
Objetivo do Desafio:

Desenvolver automação para simular a criação de duas contas, ambas com saldo, na app Web do Banco BugBank. Acessar uma das contas criadas, realizar Transferência de valores para a outra conta, e validar saída e entrada de ambas.

## Caso de Teste (Realizar Transferência entre contas):

Cenário 1 (criar conta1):
- Acessar o site do BugBank;
- Clicar no botão "Registrar";
- Preencher o formulário de registro com dados válidos, e criar uma conta (conta1);
- Realizar Login com a conta1;
- Extrair número da conta criada;
- Logout da conta1;

Cenário 2 (crar conta2):
- Clicar no botão "Registrar";
- Preencher o formulário de registro com dados válidos, e criar uma conta (conta2);
- Realizar Login com a conta2;
- Extrair número da conta criada;
- Logout da conta2;

Cenário 3 (realizar Transferência):
- Login com a conta1;
- Acessar área de Transferência;
- Preencher o formulário da Transferência com os dados da conta2;
- Preencher valor desejado da Transferência;
- Aguardar pop-up com a confirmação da Transferência Realizada;

Cenário 4 (validar saída de valor da conta1):
- Ainda logado na conta1 visualizar detalhes da conta, e validar o valor esperado após saída da quantia por Transferência;
- Deve visualizar no terminal da IDE aprovação do Teste realizado;
- Logout da conta1;

Cenário 5 (validar entrada de valor na conta2):
- Realizar Login na conta2;
- Visualizar detalhes da conta2, validar visualização do valor esperado após recebimento da Transferência;
- Deve visualizar no terminal da IDE aprovação do Teste realizado;
- Fechamento da página da Web BugBank.

  ## Tecnologias Utilizadas / Frameworks / Bibliotecas

- IntelliJ IDEA Community Edition 2023.1;
- Selenium;
- Java JDK 11;
- JUnit5;

##	Executando o projeto:
 - Executar o git - comando Git Bash here;
 - Clonar o projeto - comando git clone 
 - Abrir o projeto no Intellij;
 - Atualizar dependências com Maven (Reload all Maven Project);
 - Executar casoTeste - RealizarTransferenciaEntreContas;

   ## Dependências  Utilizadas - arquivo pom.xml:
- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.15.0
- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0
