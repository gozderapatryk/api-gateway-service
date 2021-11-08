package pl.gozderapatryk.apigatewayservice.routing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.gozderapatryk.apigatewayservice.proxy.UserServiceProxy;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RoutingHandlers {

    private final UserServiceProxy userServiceProxy;

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        Long id = Long.valueOf(serverRequest.pathVariable("id"));
        return userServiceProxy
                .findById(id)
                .flatMap(getUserDto -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(getUserDto))
                );
    }
}
