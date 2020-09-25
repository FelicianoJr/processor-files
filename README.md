#processor-files
=========================

### Sobre o Projeto

O projeto executa leitura, processamento e escrita  de arquivos .dat. O resultado do processamento gera um relatório que inclui cálculos da quantidade de clientes,
quantidade de vendedores, o id da venda mais cara e o nome do vendedor menos vendeu.  

## Tecnologias do projeto

  * Java 1.8
  * camel-spring-boot 3.5.0 
  * lombok 
  * Junit 5
  
## Construção

Necessário JDK 8 , Maven 3.5.2 ou mais recente e o Git instalado.

	java -version
	mvn -version
	git --version

Para construir o aplicativo, execute:

    mvn clean
    mvn install package

Para executar a aplicação sem executar os testes, insira o parâmetro:

    mvn clean spring-boot:run -Dmaven.test.skip=true

## Iniciando a aplicação localmente

Seguindo os passos acima, em seguida execute:

    mvn clean spring-boot:run 

Para parar o servidor , pressione 'Crtl+C'.


Execução do docker é necessário ter executado o build do maven.
Para executar os comandos do docker acesse a raiz do projeto.

Construir a imagem:

docker build -t app:demo .

Executar a imagem:

docker run app/demo



