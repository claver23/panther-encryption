package com.etlions.pantherencryption.service.impl;

import com.etlions.pantherencryption.service.RSAEncryptionService;
import com.etlions.pantherencryption.utils.RSAKeyPairGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class RSAEncryptionServiceImpl implements RSAEncryptionService {

    private RSAKeyPairGenerator keyPairGenerator;

    @Override
    public Flux<String> generateKeys() {
        return null;
    }

    @Override
    public Flux<byte[]> encrypt(String plainText) throws Exception {
        PublicKey publicKey = keyPairGenerator.getKeyPair().getPublic();

        KeyPair secondKeyPair = keyPairGenerator.getKeyPair();
        System.out.println(secondKeyPair.getPublic().toString());
        System.out.println(secondKeyPair.getPrivate().toString());

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Flux.just(cipher.doFinal(plainText.getBytes()));
    }

    @Override
    public Flux<String> decrypt(String ciphertext) throws Exception {
        PrivateKey privateKey = keyPairGenerator.getKeyPair().getPrivate();

        System.out.println(privateKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext.getBytes());
        return Flux.just(new String(decryptedBytes));
    }
}
