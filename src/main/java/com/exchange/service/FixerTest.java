package com.exchange.service;

import org.springframework.web.client.RestTemplate;

public class FixerTest {
    public static void main(String[] args) throws Exception {
        String url = "https://data.fixer.io/api/latest?access_key=1234567890abcdef1234567890abcdef&symbols=USD,TRY";

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);
        System.out.println("JSON yanıtı:");
        System.out.println(json);
    }
}
