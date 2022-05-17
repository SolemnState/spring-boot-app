package innotech.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import innotech.springboot.dto.DateDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


@RestController
@RequestMapping("/mockService")
public class MockDateController {

    @GetMapping(produces = "application/json")
    public DateDTO mockDate() throws IOException, InterruptedException {
        String uri = "http://localhost:8082/mock";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .header("content-type", MediaType.APPLICATION_JSON_VALUE)
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper.readValue(response.body(), DateDTO.class);
    }

}
