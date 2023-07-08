package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldApplicationTests {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testHelloEndpoint() {
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:" + port + "/", HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Hello, Spring Boot!", responseEntity.getBody());
    }
}