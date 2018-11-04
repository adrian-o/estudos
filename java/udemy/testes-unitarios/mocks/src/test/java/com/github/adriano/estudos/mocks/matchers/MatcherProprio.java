package com.github.adriano.estudos.mocks.matchers;

import java.util.Calendar;

public class MatcherProprio {

	public static DiaSemanaMatcher caiEm(Integer diaSemana) {
		return new DiaSemanaMatcher(diaSemana);
	}

	public static DiaSemanaMatcher caiSegunda() {
		return new DiaSemanaMatcher(Calendar.MONDAY);
	}
	
	public static MesmaDataMatcher ehHojeComDiferencaDeDias(Integer diferencaDias) {
		return new MesmaDataMatcher(diferencaDias);
	}
}