package org.example.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample implements Run {
    @Override
    public void run() {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소: " + local.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress remote : iaArr){
                System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
