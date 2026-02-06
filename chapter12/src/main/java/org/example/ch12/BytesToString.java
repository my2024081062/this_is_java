package org.example.ch12;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToString {
    public void bytesToString() throws UnsupportedEncodingException {
        String data = "자바";
        byte[] bytes1 = data.getBytes();
        System.out.println("bytes1: " + Arrays.toString(bytes1));

        String str1 = new String(bytes1);
        System.out.println("str1: " + str1);

        byte[] bytes2 = data.getBytes("EUC-KR");
        System.out.println("bytes2: " + Arrays.toString(bytes2));

        String str2 = new String(bytes2,"EUC-KR");
        System.out.println("str2: " + str2);
    }
}
