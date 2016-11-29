# Apache Camel SNMP trap
This is where the magic happens:
[/snmp-server/blob/master/src/main/java/com/c2systems/snmp/trapper/SNMPTrap.java](https://github.com/jsteffensen/snmp-server/blob/master/src/main/java/com/c2systems/snmp/trapper/SNMPTrap.java)

* Import into Eclipse
* Export to runnable .jar

Then run using `java -jar snmp-server.jar`

![run server](https://raw.githubusercontent.com/jsteffensen/snmp-server/master/imgs/screen1.png)

Test with [https://www.snmpsoft.com/cmd-tools/snmp-trap-gen/](https://www.snmpsoft.com/cmd-tools/snmp-trap-gen/)

![test with SnmpTrapGen](https://raw.githubusercontent.com/jsteffensen/snmp-server/master/imgs/screen2.png)

Print String representation to System.out:

![Prints to System.out](https://raw.githubusercontent.com/jsteffensen/snmp-server/master/imgs/screen3.png)
