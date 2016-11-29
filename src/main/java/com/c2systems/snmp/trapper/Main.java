package com.c2systems.snmp.trapper;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.snmp.SnmpComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	public static Processor myProcessor = new Processor() {
		public void process(Exchange arg0) throws Exception {
			// save to database
		}
	};

	public static void main(String[] args) {

		CamelContext context = new DefaultCamelContext();
		context.addComponent("snmp", new SnmpComponent());

		RouteBuilder builder = new RouteBuilder() {
		    public void configure() {
		        from("snmp:127.0.0.1:162?protocol=udp&type=TRAP").process(myProcessor);
		    }
		};

		try {
			context.addRoutes(builder);
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
