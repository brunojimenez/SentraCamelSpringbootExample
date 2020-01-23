# Sentra Camel Springboot Example

Se debe crear un proyecto con https://start.spring.io/ que al menos tenga Camel.

Luego de esto, puedes importar el proyecto a Spring Tool Suite (Eclipse).

Al revisar los fuentes, se encontrará una clase con la anotación @SpringBootApplication.

```
package cl.sentra.bjimenez.camel.example.DemoCamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCamelApplication.class, args);
	}

}
```

Se le debe agregar una llamada a contexto de Camel con la anotación @ImportResource.

```
package cl.sentra.bjimenez.camel.example.DemoCamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportResource({"classpath:/spring-camel-context.xml"})
public class DemoCamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCamelApplication.class, args);
	}

}
```

El archivo spring-camel-context.xml, debe estar dentro del classpath (ojalá src/main/resources/) y puedes obtener una versión inicial del XML en https://camel.apache.org/components/latest/spring.html.

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://camel.apache.org/schema/spring http://camel.apache.org/schema/spring/camel-spring.xsd
    ">

  <camelContext id="camel-A" xmlns="http://camel.apache.org/schema/spring">
    <route>
      <from uri="seda:start"/>
      <to uri="mock:result"/>
    </route>
  </camelContext>

</beans>
```
