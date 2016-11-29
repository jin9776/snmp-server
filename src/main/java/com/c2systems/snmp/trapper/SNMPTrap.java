package com.c2systems.snmp.trapper;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Main;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.snmp.SnmpComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;

public class SNMPTrap {

    private Main main;



    public static void main(String[] args) throws Exception {
    	SNMPTrap example = new SNMPTrap();
        example.boot();
    }

    @SuppressWarnings("deprecation")
	public void boot() throws Exception {

        main = new Main();
        main.bind("snmp", new SnmpComponent());
        main.addRouteBuilder(new MyRouteBuilder());
        main.addMainListener(new Events());

        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();
    }

    private static class MyRouteBuilder extends RouteBuilder {
        @Override
        public void configure() throws Exception {
        	from("snmp:127.0.0.1:162?protocol=udp&type=TRAP").process(myProcessor)
                .bean("snmp");
        }
    }

    public static Processor myProcessor = new Processor() {
        public void process(Exchange arg0) throws Exception {
            // save to database
        }
    };

    public static class Events extends MainListenerSupport {

        @Override
        public void afterStart(MainSupport main) {
            System.out.println("MainExample with Camel is now started!");
        }

        @Override
        public void beforeStop(MainSupport main) {
            System.out.println("MainExample with Camel is now being stopped!");
        }
    }
}
