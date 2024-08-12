package com.mrohana.estudos.camel.camelapp1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRouter extends RouteBuilder  {
	
	@Override
	public void configure() throws Exception {
		/* Sending to queue by timer
		from("timer:active-mq-timer?period=10000")
		.transform().constant("My message for Active MQ")
		.to("activemq:my-activemq-queue-1");
		*/
		
		/* Sending JSon file */
		from("file:files/json")
		.log("${body}")
		.to("activemq:my-activemq-queue-2");
	}
}
