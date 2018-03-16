# AbutresNET
Sistema Gerenciamento do Abutres Moto Clube Brasil

## Objetivo
O sistema terá o objetivo de gerenciar todos os processos internos do Moto Clube e será destinado inicialmente somente para o Comando maior e para a Diretoria (Diretores e Sub-Diretores) do Moto Clube Abutres em todo o mundo.

## Funcionalidades
 * Endereços de Subsedes
 * Contatos de Diretorias
 * Diretrizes
 * Normas
 * Manuais
 * Comunicados e ciência
 * Imagens oficiais
 * Solicitações
 * Cores e upload de comprovante
 * Transferencias, etc
 * Interação em grupo (Bate papo)
 
 
 ## Configurando ambiente
 
 ## Instalando Git

Git é um controle de versão distribuído e um sistema de gerenciamento de código fonte com enfase em velocidade. Inicialmente ele foi desenhado e desenvolvido pelo Linus Torvalds para o desenvolvimento do kernel do Linux, desde então ele tem se popularizado no mundo opensource e é utilizado em milhares de projetos.

Para instalar o Git no Ubuntu basta executar o comando abaixo:
``` 
 $ sudo apt-get install git
``` 
# Configurando sua identidade no Git

A primeira coisa a se fazer logo após a instalação do Git é configurar seu nome de usuário e endereço de e-mail. Isto é importante pois cada commit no Git usa esta informação e ela é imutável a partir daí.

Se você não fornecer estas informações, o Git utilizará as informações locais da sua máquina - o que normalmente não é o que você quer.

Execute os comandos abaixo para configurar seu usuário e e-mail:
``` 
 $ git config --global user.name "Your Name Here"
 $ git config --global user.email "your_email@example.com"
```
# Gerando sua SSH Key
Para se conectar à um servidor Git de forma segura você precisa gerar uma SSH Key (chave pública e privada). Esta chave deverá ser registrada no servidor Git para que seja possível ter acesso aos repositórios dos projetos.

ATENÇÃO: Caso você já possua uma SSH Key configurada, você não precisa regera-la, mas somente registra-la no servidor Git.
Para registrar sua chave você precisa executar os comandos abaixo
``` 
 $ ssh-keygen -t rsa -C "your_email@example.com"
``` 
Tecle <ENTER> para todas as perguntas do comando acima - são 3 perguntas.
Mais informações sobre como gerar SSH Keys? Veja em "Generating SSH Keys".

Caso precise de mais detalhes sobre o Git, como utiliza-lo e seus comandos básicos, por favor, leia este guia prático e sem complicação.

# Instalar o Maven

No MAC
``` 
 $ brew install maven
``` 
No Linux
``` 
 $ sudo apt-get --no install-recomends install maven
``` 
O argumento --no-install-recommends evita que o apt-get instale dependências desnecessárias, entre elas o OpenJDK 6 - pois utilizamos o OpenJDK 7.

Para verificar a versao correta:
``` 
 $ mvn --version
```  
Vai aparecer algo como:

Apache Maven 3.5.3 (3383c37e1f9e9b3bc3df5050c29c8aff9f295297; 2018-02-24T16:49:05-03:00)
Maven home: /usr/local/Cellar/maven/3.5.3/libexec
Java version: 1.8.0_161, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre
Default locale: pt_BR, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.6", arch: "x86_64", family: "mac" 
 
 
