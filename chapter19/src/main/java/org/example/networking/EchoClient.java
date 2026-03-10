package org.example.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient {
    public void run(){
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            //내 IP : 10.11.83.62
            Socket socket = new Socket("localhost",50001);
            System.out.println("[클라이언트] 연결 성공");

            //데이터 보내기
            String sendMassage = "i love java";
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(sendMassage);
            dos.flush();
            System.out.println("[클라이언트] 데이터 보냄: " + sendMassage);
            dis = new DataInputStream(socket.getInputStream());
            String receiveMassage = dis.readUTF();
            System.out.println("[클라이언트] 데이터 받음: " + receiveMassage);

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        EchoClient client = new EchoClient();
        client.run();
    }
}
