package pl.gozderapatryk.apigatewayservice.proxy;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.gozderapatryk.apigatewayservice.dto.GetUserDto;
import reactor.core.publisher.Mono;

@Service
public class UserServiceProxy {

    private final WebClient webClient;


    public UserServiceProxy(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<GetUserDto> findById(Long id) {
        return webClient
                .get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(GetUserDto.class);
    }
}
