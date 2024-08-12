package com.mrohana.estudos.camel.camelapp1.routes;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class FirtsTimerRouter extends RouteBuilder {

	@Autowired
	private GetCurrentTimerBean getCurrentTimerBean;
	
	@Autowired
	private SimpleLoggingComponent logComponent;
	
	@Autowired
	private SimpleLogginProcessor logProcessor;
	
	
	/** Using transform and beans to transform messages...
	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
			.log("${body}")
			.transform().constant("My log test...")
			.log("${body}")
			.bean(getCurrentTimerBean, "getCurrentTime")
			.log("${body}")
			.bean(logComponent);
			//.to("log:first-timer");
	}*/

	// Using processors
	@Override
	public void configure() throws Exception {
		from("timer:first-timer")
		.bean(getCurrentTimerBean, "getCurrentTime")
		.process(logProcessor)	
		.to("log:first-timer");
	}
	
}

@Component
class GetCurrentTimerBean {
	public String getCurrentTime() {
		return "The time now is " + LocalDateTime.now();
	}
}

@Component
class SimpleLoggingComponent {
	
	private Logger log = LoggerFactory.getLogger(SimpleLoggingComponent.class);
	
	public void process(String message) {
		log.info("SimpleLogComponent {}", message);
	}
}

@Component
class SimpleLogginProcessor implements Processor {

	private Logger log = LoggerFactory.getLogger(SimpleLogginProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("SimpleLogginProcessor {}", exchange.getMessage().getBody());
	}

}