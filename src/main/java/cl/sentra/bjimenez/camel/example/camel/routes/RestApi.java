package cl.sentra.bjimenez.camel.example.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApi extends RouteBuilder {
	@Override
	public void configure() {

		// CamelContext context = new DefaultCamelContext();

		// component("netty-http") -> camel-netty-http
		// component("undertow") -> camel-undertow

		restConfiguration().port("8889").component("undertow").bindingMode(RestBindingMode.auto)
				.dataFormatProperty("prettyPrint", "true").contextPath("/").apiProperty("cors", "true")
				.apiContextPath("/api-doc").apiProperty("api.title", "REST API").apiProperty("api.version", "v1");

		// .responseMessage().code(200).message("All fine").endResponseMessage()

		// Api User
		rest("/api/user").description("Api User").consumes("application/json").produces("application/json").post("/")
				.description("Create User").to("direct:userCreate").get("/{id}").description("Read User")
				.to("direct:userRead").put("/").description("Update User").to("direct:userUpdate").delete("/{id}")
				.description("Delete User").to("direct:userDelete");

		// User CRUD
		from("direct:userCreate").tracing().log("${body}").setBody().simple("direct:userCreate");
		from("direct:userRead").tracing().log("${body}").setBody().simple("direct:userRead");
		from("direct:userUpdate").tracing().log("${body}").setBody().simple("direct:userUpdate");
		from("direct:userDelete").tracing().log("${body}").setBody().simple("direct:userDelete");

	}
}