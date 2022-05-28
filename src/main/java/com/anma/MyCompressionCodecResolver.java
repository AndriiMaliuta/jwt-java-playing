package com.anma;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.Header;

public class MyCompressionCodecResolver implements CompressionCodecResolver {
    @Override
    public CompressionCodec resolveCompressionCodec(Header header) throws CompressionException {
        String alg = header.getCompressionAlgorithm();
        CompressionCodec codec = getCompressionCodec(alg); //implement me
        return codec;
    }

    private CompressionCodec getCompressionCodec(String alg) {
        return null;
    }
}
