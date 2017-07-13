package com.devil.interfaceDefault;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class Base64s {
    public static void main(String[] args) {
        final String text = "base64 finally in java 8";
        final String encode = Base64.getEncoder().encodeToString(text.getBytes(UTF_8));
        System.out.println("encode = " + encode);
        final String decoder = new String(Base64.getDecoder().decode(encode), UTF_8);
        System.out.println("decoder = " + decoder);
    }
}
