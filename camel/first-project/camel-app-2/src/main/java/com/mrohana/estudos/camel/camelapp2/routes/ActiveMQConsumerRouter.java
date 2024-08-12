package com.mrohana.estudos.camel.camelapp2.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.mrohana.estudos.camel.camelapp2.routes.beans.PersonBean;

@Component
public class ActiveMQConsumerRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:my-activemq-queue-2")
		.unmarshal().json(JsonLibrary.Jackson, PersonBean.class)
		.to("log:received-from-activemq-queue-1");
	}

}


