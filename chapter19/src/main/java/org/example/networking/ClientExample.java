package org.example.networking;

import java.io.IOException;
import java.net.Socket;

public class ClientExample implements Run {
    public void run(){
        try {
            //내 IP : 10.11.83.62
            Socket socket = new Socket("10.11.83.62",50001);
            System.out.println("[클라이언트] 연결 성공");

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
