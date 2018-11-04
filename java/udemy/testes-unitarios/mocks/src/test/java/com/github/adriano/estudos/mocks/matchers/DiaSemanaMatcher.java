package com.github.adriano.estudos.mocks.matchers;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.github.adriano.estudos.mocks.utils.DataUtils;

public class DiaSemanaMatcher extends TypeSafeMatcher<Date> {

	private Integer diaSemana;
	
	public DiaSemanaMatcher(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public void describeTo(Description description) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, diaSemana);
		String extenso = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("pt","BR"));
		description.appendText(extenso);
	}

	protected boolean matchesSafely(Date data) {		
		return DataUtils.verificarDiaSemana(data, diaSemana);
	}

}
