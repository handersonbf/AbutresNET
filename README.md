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

sudo apt-get install git

# Configurando sua identidade no Git

A primeira coisa a se fazer logo após a instalação do Git é configurar seu nome de usuário e endereço de e-mail. Isto é importante pois cada commit no Git usa esta informação e ela é imutável a partir daí.

Se você não fornecer estas informações, o Git utilizará as informações locais da sua máquina - o que normalmente não é o que você quer.

Execute os comandos abaixo para configurar seu usuário e e-mail:

git config --global user.name "Your Name Here"
git config --global user.email "your_email@example.com"

# Gerando sua SSH Key
Para se conectar à um servidor Git de forma segura você precisa gerar uma SSH Key (chave pública e privada). Esta chave deverá ser registrada no servidor Git para que seja possível ter acesso aos repositórios dos projetos.

ATENÇÃO: Caso você já possua uma SSH Key configurada, você não precisa regera-la, mas somente registra-la no servidor Git.
Para registrar sua chave você precisa executar os comandos abaixo

ssh-keygen -t rsa -C "your_email@example.com"

Tecle <ENTER> para todas as perguntas do comando acima - são 3 perguntas.
Mais informações sobre como gerar SSH Keys? Veja em "Generating SSH Keys".

Caso precise de mais detalhes sobre o Git, como utiliza-lo e seus comandos básicos, por favor, leia este guia prático e sem complicação.







brew install maven

mvn install 
e vá tomar um café....tomar banho sei la







Maven é uma ferramenta para gerenciamento e automatização de projetos Java. Ela cuidará de tarefas como compilação, rodar bateria de testes, gerar o .war e configurar as dependências do projeto no Eclipse. Toda a configuração do Maven se encontra no arquivo pom.xml que fica dentro da raiz de cada projeto.

Para instala-lo é fáicl, basta executar o comando abaixo:

sudo apt-get --no-install-recommends install maven
O argumento --no-install-recommends evita que o apt-get instale dependências desnecessárias, entre elas o OpenJDK 6 - pois utilizamos o OpenJDK 7.

Para verificar se o Maven foi instalado corretamente, execute o comando abaixo:

mvn --version
A saída no console será semelhante a isto:

Apache Maven 3.0.4
Maven home: /usr/share/maven
Java version: 1.7.0_25, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-openjdk-amd64/jre
Default locale: pt_BR, platform encoding: UTF-8
OS name: "linux", version: "3.5.0-23-generic", arch: "amd64", family: "unix"


Caso tenha 3h sobrando no seu dia, você pode assistir o screencast gratuito do AkitaOnRails.

Instalando Postgresql
PostgreSQL é um poderoso sistema de gerenciamento de banco de dados (SGBD) opensource. Com mais de 15 anos de desenvolvimento ativo, hoje ele está disponível em praticamente todos os sistemas operacionais.

Trabalharemos com o Postgresql 9.1.

Para instalar o Postgres basta executar o comando abaixo:

sudo apt-get install postgresql-9.1
Configurando a senha do Postgresql
O ideal é que todos os desenvolvedores utilizem sempre o mesmo usuário e senha do banco no ambiente de desenvolvimento, evitando assim modificações no arquivo de configuração da aplicação.

sudo -u postgres psql postgres
ALTER USER postgres WITH PASSWORD '123';
\q
No comando acima, o usuário postgres terá sua senha configurada para "123".

Habilitando conexões TCP/IP no Postgresql
Por padrão o Postgres não suporta conexões locais nem remotas via TCP/IP, sendo impossível abrir conexões JDBC. Logo se faz necessário configurar o Postgres para suportar este tipo de conexão. Siga os passos abaixo:

Primeiramente abra o arquivo postgresql.conf
sudo nano /etc/postgresql/9.1/main/postgresql.conf
Localize a linha abaixo dentro do arquivo
#listen_addresses = 'localhost'
E substitua a linha acima por esta outra linha:
listen_addresses = '*'
Depois abra o arquivo pg_hba.conf
sudo nano /etc/postgresql/9.1/main/pg_hba.conf
Localize a linha abaixo dentro do pg_hba.conf
host all all  127.0.0.1/32 md5
E substitua a linha acima por esta outra linha:
host all all  0.0.0.0/0 md5
Reniciei o Postgres
sudo service postgresql restart
Pronto! Desta forma será possível conectar no banco dados via JDBC tanto localmente como remotamente.

Instalando o PgAdmin
PgAdmin é uma ferramenta de gerenciamento, desenvolvimento e administração do Postgres. Através dele é que poderemos acessar o banco de dados das nossas aplicações, executar comandos SQL e administrar nossos esquemas.

Para instala-lo, simplesmente execute o comando abaixo:

sudo apt-get install pgadmin3
Após instalar o PgAdmin, execute-o, crie uma conexão localhost e tente acessar seu banco para verificar se o Postgresql foi instalado e configurado corretamente.



Installing by hand:
Download Maven from its homepage
Follow the installation instructions:
Extract the distribution archive, i.e.apache-maven-3.3.9-bin.tar.gz to the directory you wish to install Maven 3.3.9. The subdirectory apache-maven-3.3.9 will be created from the archive.
Optional: Add the MAVEN_OPTS environment variable to specify JVM properties, e.g.  export MAVEN_OPTS="-Xms256m -Xmx512m". This environment variable can be used to supply extra options to Maven.
Make sure that JAVA_HOME is set to the location of your JDK, e.g. export JAVA_HOME=$(/usr/libexec/java_home -v 1.8) and that $JAVA_HOME/bin is in your PATH environment variable (although that might not be necessary with the latest Mac OS X versions and the Oracle JDK).
Add extracted apache-maven-3.3.9/bin to your $PATH
Run mvn --version to verify that it is correctly installed.
 
 
 
