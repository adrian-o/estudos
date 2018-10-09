# Sobre testes
Criado para absorver todos os conceitos de testes unitários que eu consegui captar durante os estudos e também insights que venham a surgir assim como dúvidas.

## First principle
* Fast                 = deve ser executado rápido.
* Independent/Isolated = não deve possuir dependência de outros testes.
* Repeatable     	   = pode ser executado quantas vezes quiser e na hora que eu quiser.
* Self-verifying 	   = um teste deve saber quando obteve sucesso ou falha.
* Timely         	   = oportuno. Deve ser criado quando realmente precisarmos dele.

## XUnit
Deriva-se do SUnit criado para Smaltalk. Especifica alguns pontos que frameworks que o seguem devem definir:
* TestRunner - executa os testes e coleta os resultados
* TestFixture - pre-condições necessárias para o teste
* TestSuites - elenca os testes que devem ser executados
* TestResultFormatter - padroniza os resultados
* Assertions - verificam o comportamentos ou estado através de uma expressão lógica 

Exemplos:
* [JUnit] (https://junit.org)
* [TestNG] (https://testng.org/doc/index.html)
* [NUnit] (https://nunit.org/)
* [PHPUnit] (https://phpunit.de/)
* [JSUnit] (http://www.jsunit.net/)
* [LuaUnit] (https://luaunit.readthedocs.io/en/luaunit_v3_2_1/)

# Formas

## Elegante
* Usa a exception específica na anotação e serve apenas quando você quer testar o cenário específico onde a exceção vai ocorrer.
* Não precisa da mensagem da exceção, apenas do tipo.

## Robusta
* Dar mais controle, pois permite tratar exceção e manipular o restante do código após disparar a exceção.
* Precisa da mensagem para validar a exceção no catch ao capturá-la.

## Nova
* Igual a elegante, mas precisa dizer exatamente qual a mensagem que será retornada 