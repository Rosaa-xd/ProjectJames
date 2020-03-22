package com.projectjames.lightservice.util;

import com.projectjames.lightservice.config.Config;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Request {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String BASE_URL = "http://" +
            Config.IP_ADDRESS +
            "/api/" +
            Config.USERNAME;

    public static ResponseEntity request(
            String endpoint,
            HashMap<String, Object> params,
            String body,
            HttpMethod httpMethod) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String url = BASE_URL + endpoint;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        HttpEntity entity;

        if (params == null && body == null) {
            entity = new HttpEntity(httpHeaders);
        }
        else if (params == null) {
            entity = new HttpEntity(body, httpHeaders);
        }
        else if (body == null) {
            entity = new HttpEntity(httpHeaders);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue().toString());
            }
            url = builder.toUriString();
        }
        else {
            entity = new HttpEntity(body, httpHeaders);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue().toString());
            }
            url = builder.toUriString();
        }

        return REST_TEMPLATE.exchange(url, httpMethod, entity, String.class);
    }
}
