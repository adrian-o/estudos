### Anotações sobre estudos do Java 8

## Gerais

- Qualquer interface Java com apenas 1 método <b>abstract</b> pode ser usada como Lambda.

- Você pode declarar sua interface como @FuntcionalInterface a fim de evitar acidentes em versões posteriores.

- @Functional interfaces são a base dos lambdas. 

- Um lambda gera um .class gerada em tempo de execução. Cada lambda é um .class novo.

- Variáveis locais devem ser <b>final</b> ao serem usadas em Lambdas, você pode usar uma variável em um lambda sem ser final, porém se tentar utilizá-la após o escopo do lambda receberá um erro de compilação.

- No Java 8, o time resolveu permitir código implementado dentro de interfaces através do recurso de <b>deafult methods</b>. Com a adição de vários métodos que seriam cruciais para as novas versões do Java com programação funcional, apenas criar os novos métodos abstratos nas interfaces faria com que uma gama de projetos e frameworks de comunidade fossem obrigados a mudar todas as suas versões funcionaidades ao risco de dificultar a migração de projetos para a nova versão do Java.


## Collections
###List
- forEach(Consumer)
- removeIf(Predicate)