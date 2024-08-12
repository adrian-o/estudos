package com.mrohana.estudos.camel.udemyproj1.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstRouter extends RouteBuilder {

	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;
	
	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
			.bean(getCurrentTimeBean, "getCurrentTime")
			.to("log:first-timer");
	}

}

@Component
class GetCurrentTimeBean {
	public String getCurrentTime() {
		return "Timer now is " + LocalDateTime.now();
	}
}
