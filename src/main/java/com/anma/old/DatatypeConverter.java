package com.anma.old;

import java.util.Base64;

public class DatatypeConverter {
    public static byte[] parseBase64Binary(String key) {
        return Base64.getEncoder().encode(key.getBytes());
    }
}
