package com.etlions.pantherencryption.controller;

import com.etlions.springreactiveopenapicodegen.api.v1.KeysApi;
import com.etlions.springreactiveopenapicodegen.dto.SuccessResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class KeyController implements KeysApi {
    @Override
    public Mono<ResponseEntity<Flux<SuccessResponseDTO>>> createKeysGet(ServerWebExchange exchange) {
        return KeysApi.super.createKeysGet(exchange);
    }
}
