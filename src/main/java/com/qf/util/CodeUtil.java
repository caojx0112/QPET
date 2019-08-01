package com.qf.util;

import java.util.Random;

public class CodeUtil {
    private final static int codeLength =5;
    public static String getCode() {
        Random rand = new Random();
        int a;
        String code = "";
        for (int j = 0; j < codeLength; j++) {
            a = Math.abs(rand.nextInt() % 9);
            code += String.valueOf(a);
        }
        return code;
    }
}
