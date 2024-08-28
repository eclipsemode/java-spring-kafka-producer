package ru.daniel.restapi.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.daniel.restapi.DTO.AuthDTO;


@Setter
@RestController
public class AuthController {

    @Value("${client-id}")
    private String clientId;

    @Value("${resource-url}")
    private String resourceUrl;

    @Value("${grant-type}")
    private String grantType;

    @PostMapping("/auth")
    public String auth(@RequestBody AuthDTO authDTO) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        var body = "client_id=" + clientId +
                "&username=" + authDTO.login() +
                "&password=" + authDTO.password() +
                "&grant_type=" + grantType;

        var requestEntity = new HttpEntity<Object>(body, headers);
        var restTemplate = new RestTemplate();

        var response = restTemplate.exchange(
                resourceUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode().value() == 200) {
            return response.getBody();
        }

        return null;
    }
}
