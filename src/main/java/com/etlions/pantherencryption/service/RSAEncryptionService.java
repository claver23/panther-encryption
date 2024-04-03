package com.etlions.pantherencryption.service;


import reactor.core.publisher.Flux;

public interface RSAEncryptionService {

    public Flux<String> generateKeys();

    public Flux<byte[]> encrypt(String plainText) throws Exception;

    public Flux<String> decrypt(String ciphertext) throws Exception;
}
