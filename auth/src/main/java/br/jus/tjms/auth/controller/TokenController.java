package br.jus.tjms.auth.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/token")
public class TokenController {

    private RestTemplate restTemplate;

    public TokenController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String token(@RequestBody User user) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", user.clientId);
        params.add("username", user.username);
        params.add("password", user.password);
        params.add("grant_type", user.grantType);

        HttpEntity<MultiValueMap<String, String>> entity =
            new HttpEntity<>(params, headers);

        return restTemplate.postForEntity(
            "http://localhost:8080/realms/desenvolvimento/protocol/openid-connect/token",
            entity,
            String.class
        ).getBody();
    }

    private record User(
        String clientId,
        String username,
        String password,
        String grantType
    ){}
}
