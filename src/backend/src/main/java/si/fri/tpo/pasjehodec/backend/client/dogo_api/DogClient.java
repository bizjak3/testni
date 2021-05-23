package si.fri.tpo.pasjehodec.backend.client.dogo_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import si.fri.tpo.pasjehodec.backend.client.dogo_api.models.DogApiRoot;

import java.util.List;

@Service
public class DogClient {

    @Value("${dogapi.baseurl}")
    private String baseUrl;

    @Value("${dogapi.apikey}")
    private String apiKey;

    public List<DogApiRoot> getDogBreeds() {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl + "breeds")
                .defaultHeader("x-api-key", apiKey)
                .build();

        return webClient.get()
                .retrieve()
                .bodyToFlux(DogApiRoot.class)
                .collectList()
                .block();
    }
}
