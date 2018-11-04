package com.github.adriano.estudos.mocks.matchers;

import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.github.adriano.estudos.mocks.utils.DataUtils;

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
