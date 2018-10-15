package br.ce.wcaquino.matchers;

import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import br.ce.wcaquino.utils.DataUtils;

public class MesmaDataMatcher extends TypeSafeMatcher<Date> {

	private Integer diferenca;
	
	public MesmaDataMatcher(Integer diferenca) {
		this.diferenca = diferenca;
	}

	public void describeTo(Description description) {
		description.appendText(DataUtils.obterDataComDiferencaDias(diferenca).toString());
	}

	protected boolean matchesSafely(Date data) {
		return DataUtils.isMesmaData(data, DataUtils.obterDataComDiferencaDias(diferenca));
	}

}
