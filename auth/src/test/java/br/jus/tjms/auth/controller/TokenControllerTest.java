package br.jus.tjms.auth.controller;

import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

public class TokenControllerTest {

    private final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private final TokenController subject = new TokenController(restTemplate);

}
