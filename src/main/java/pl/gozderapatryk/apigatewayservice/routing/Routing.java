package pl.gozderapatryk.apigatewayservice.routing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class Routing {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(RoutingHandlers routingHandlers) {
        return route(GET("/").and(accept(MediaType.APPLICATION_JSON)), routingHandlers::findAll);
    }
}
