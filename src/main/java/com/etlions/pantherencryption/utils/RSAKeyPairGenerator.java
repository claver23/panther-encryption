package com.etlions.pantherencryption.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@Component
public class RSAKeyPairGenerator {

    private KeyPair keyPair;

    @PostConstruct
    public void init() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512); // Key size
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }
}
