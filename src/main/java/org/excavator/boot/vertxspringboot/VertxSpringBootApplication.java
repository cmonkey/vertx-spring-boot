package org.excavator.boot.vertxspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class VertxSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VertxSpringBootApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> helloRouter(){
	    return route()
	        .GET("/hello", this::helloHandler)
	        .build();
	}

	private Mono<ServerResponse> helloHandler(ServerRequest request){
	    String name = request.queryParam("name")
	        .orElse("World");

	    String messages = String.format("Hello, %s!", name);

	    return ok().body(fromValue(messages));
	}

}
