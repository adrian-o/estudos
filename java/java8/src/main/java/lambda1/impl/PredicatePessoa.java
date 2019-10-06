package lambda1.impl;

import lambda1.Pessoa;

import java.util.function.Predicate;

public class PredicatePessoa implements Predicate<Pessoa> {
    @Override
    public boolean test(Pessoa pessoa) {
        return pessoa.calculaIdade() < 18;
    }
}
