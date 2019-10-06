package lambda1.impl;

import lambda1.Pessoa;

import java.util.function.Consumer;

/**
 * Interface Consumer está implementada no Iterable para
 * permitir que possíveis filtros no método accept barrem
 * o print de ojetos da Collection.
 */
public class ConsumerPessoa implements Consumer<Pessoa> {

    /** Método único que permite a Interface ser usada como Lambda */
    public void accept(Pessoa pessoa) {
        if (pessoa.getCpf().startsWith("0")) {
            System.out.println("Pessoa: " + pessoa.getNome());
        }
    }
}
