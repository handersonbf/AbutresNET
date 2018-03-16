# AbutresNET
Sistema Gerenciamento do Abutres Moto Clube Brasil

## Objetivo
O sistema terá o objetivo de gerenciar todos os processos internos do Moto Clube e será destinado inicialmente somente para o Comando maior e para a Diretoria (Diretores e Sub-Diretores) do Moto Clube Abutres em todo o mundo.

## Funcionalidades
- Sedes:
  - Cadastro de sedes e subsedes com seus endereços
- Membros:
  - Cadastro de membros: Neste primeiro momento apenas membros que possuam o cargo de SubDiretor para cima, deve conter os contatos do membro.
- Mídias:
  - Cadastro de mídias em PDF ou JPG
    - Diretrizes
    - Normas
    - Manuais
    - Imagens oficiais
- Comunicados e ciência
- Outras funcionalidades futuras:
  - Solicitações
  - Cores e upload de comprovante
  - Transferencias, etc
  - Interação em grupo (Bate papo)
 
## Ambiente de desenvolvimento
O ambiente de desevolvimento do projeto é configurado através da ferramenta Maven. Ela se encarregará de baixar todas as dependências (libs) e configurar o projeto no Eclipse.

**ATENÇÃO:** Configure o ambiente básico de desenvolvimento, como JDK-8, Git etc.

Para configurar o projeto siga os passos:

1. Baixe o projeto do GitHub, basta clona-lo:
``` 
$ git clone git@github.com:triadworks/AbutresNET.git
``` 
2. Importe o projeto pelo Eclipse como um projeto Maven através da opção:
``` 
File->Existing Project Maven
``` 
Os arquivos .project, .classpath e .settings serão criados. Pode demorar um pouco ao executar este comando pela primeira vez, pois o Maven precisará baixar todas as dependências do projeto.

3. **Pendente** ~~Crie os respectivos banco de dados no MySQL com o encoding utf8: abutres_net~~
4. **Pendente** ~~Rode as migrations para gerar o schema de ambos os bancos. Para isso, faça:~~
5. **Pendente** ~~Rode a bateria de testes. Para isso, faça:~~

~~Pronto! Se todos os testes passaram com "BUILD SUCCESSFUL", seu ambiente está configurado.~~

A aplicação já está configurada no Eclipse e pronta para desenvolvimento. Faça o deploy da aplicação executando o método ``main`` da classe ```AbutresNetApplication.java``` e acesse pelo browser.

http://localhost:8080/

Qualquer dúvida ou problema, é só falar.
