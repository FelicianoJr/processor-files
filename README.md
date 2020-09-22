Aplicação para análise de arquivos
=========================

## Tecnologias do projeto

  Java 1.8, 
  camel-spring-boot 3.5.0, 
  lombok, 
  Junit 5
  
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



