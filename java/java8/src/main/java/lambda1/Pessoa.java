package lambda1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class Pessoa {
    private String nome;
    private Date nasc;
    private String cpf;

    public void setNascimento(int dia,  int mes, int ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes, dia);
        this.setNasc(cal.getTime());
    }

    public Integer calculaIdade() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nasc);
        return Period.between(LocalDate.of(
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)), LocalDate.now()).getYears();
    }
}
