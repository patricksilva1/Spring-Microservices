package dev.patricksilva.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:90"))
				.route(p -> p.path("/api/people/status/**")
						.uri("lb://api/people/status"))
				.route(p -> p.path("/api/people/status-new/**")
						.filters(f -> f.rewritePath(
								"/api/people/status-new/(?<segment>.*)",
								"/api/people/status-feign/${segment}"))
						.uri("lb://api/people/status"))
				.build();
	}

}