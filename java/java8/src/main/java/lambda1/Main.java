package lambda1;

import lambda1.impl.ConsumerPessoa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas =
                Arrays.asList(
                        new Pessoa("Adriano", new Date(), "10256896325"),
                        new Pessoa("Carlos", new Date(), "25569325874"),
                        new Pessoa("José", new Date(), "02589635471"),
                        new Pessoa("Maria", new Date(), "001023566520"),
                        new Pessoa("Vitória", new Date(), "10256520520"),
                        new Pessoa("Cleiton", new Date(), "01325852258123")
                );

        // Método 1 - Usando o Consumer como classe
        ConsumerPessoa itPessoa = new ConsumerPessoa();
        pessoas.forEach(itPessoa);

        // Método 2 - Criando o Consumer em tempo de escrita
        pessoas.forEach(
                new Consumer<Pessoa>() {
                    @Override
                    public void accept(Pessoa pessoa) {
                        if (pessoa.getCpf().startsWith("1")) {
                            System.out.println(pessoa.getNome());
                        }
                    }
                }
        );

        // Método 3 - Usando lambda
        Consumer<Pessoa> c1 = (Pessoa p) -> {
            if (p.getCpf().startsWith("2")) {
                System.out.println(p.getNome());
            }
        };
        pessoas.forEach(c1);

        // Método 3 - Usando lambda  2
        Consumer<Pessoa> c2 = p -> {                    // <-- Compilador consegue inferir o tipo.
            if (p.getCpf().startsWith("3")) {
                System.out.println(p.getNome());
            }
        };
        pessoas.forEach(c2);

        // Método 3 - Usando lambda  3
        Consumer<Pessoa> c3 = p -> System.out.println(p.getNome()); // Aqui só funciona pra instruções de 1 linha
        pessoas.forEach(c3);  // <-- Vai exibir todos

        // Simplificando tudo
        pessoas.forEach(p -> System.out.println("Pessoa: " + p.getNome()));
    }
}
