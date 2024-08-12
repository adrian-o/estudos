package com.mrohana.estudos.camel.camelapp1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FirtsFileRouter extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		from("file:files/input?delay=30000")
		.log("${body}")
		.to("file:files/output");
	}
	
}