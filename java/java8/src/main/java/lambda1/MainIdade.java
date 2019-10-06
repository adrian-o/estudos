package lambda1;

import lambda1.impl.PredicatePessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainIdade {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Andréia", new Date(), "10256896325");
        p1.setNascimento(21, 4, 1992);

        Pessoa p2 = new Pessoa("Adriano", new Date(), "10256896325");
        p2.setNascimento(16, 3, 1983);

        Pessoa p3 = new Pessoa("Carla", new Date(), "10256896325");
        p3.setNascimento(12, 11, 2000);

        Pessoa p4 = new Pessoa("Rita", new Date(), "10256896325");
        p4.setNascimento(7, 10, 2001);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(Arrays.asList(p1,p2,p3,p4));

        // ForEach
        pessoas.forEach(p -> System.out.println("Pessoa: " + p.getNome() + " Idade: " + p.calculaIdade()));

        // Remove
        PredicatePessoa pred = new PredicatePessoa();
        pessoas.removeIf(pred);

        pessoas.forEach(p -> System.out.println("Pessoa: " + p.getNome()));
    }

}
