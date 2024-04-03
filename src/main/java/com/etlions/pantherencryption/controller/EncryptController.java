package com.etlions.pantherencryption.controller;


import com.etlions.pantherencryption.service.RSAEncryptionService;
import com.etlions.springreactiveopenapicodegen.api.v1.EncryptApi;
import com.etlions.springreactiveopenapicodegen.dto.SuccessResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EncryptController implements EncryptApi {

    RSAEncryptionService rsaEncryptionService;

    @Override
    public Mono<ResponseEntity<Flux<SuccessResponseDTO>>> encryptPlainTextGet(String plainText, ServerWebExchange exchange) {
      try {
        return Mono.just(ResponseEntity.ok(
                        rsaEncryptionService.encrypt(plainText)
                            .flatMap(encrypted ->
                                    Flux.just(SuccessResponseDTO.builder()
                                            .status(BigDecimal.valueOf(200))
                                            .data(encrypted)
                                            .build()))));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

}
