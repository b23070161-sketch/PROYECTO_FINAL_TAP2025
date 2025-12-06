package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncripHash {
    private MessageDigest md;
    private static EncripHash instance;

    private EncripHash() {
        try {
            this.md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static EncripHash getInstance() {
        if (instance == null) {
            instance = new EncripHash();
        }
        return instance;
    }

    public String encriptar(String texto) {
        byte[] hashBytes = md.digest(texto.getBytes());

        return Base64.getEncoder().encodeToString(hashBytes);
    }
}

