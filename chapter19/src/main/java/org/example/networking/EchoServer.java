package org.example.networking;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoServer {
    private static ServerSocket serverSocket = null;
    public void run(){
        System.out.println("--------------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 enter키를 입력하세요.");
        System.out.println("--------------------------------------------");

        this.startServer();

        Scanner scanner = new Scanner(System.in);
        while(true){
            String key = scanner.nextLine();
            if(key.equalsIgnoreCase("q")){
                break;
            }
        }
        scanner.close();

        this.stopServer();

    }

    private void startServer() {
        Thread thread = new Thread(() -> {
            DataInputStream dis = null;
            DataOutputStream dos = null;
            try{
                serverSocket = new ServerSocket(50001);
                System.out.println("[서버] 시작됨");

                while (true){
                    System.out.println("\n[서버] 연결 요청을 기다림\n");
                    Socket socket  = serverSocket.accept();

                    InetSocketAddress isa =
                        (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");
                    // 클라이언트 요청 처리
                    // 데이터 받기

                    dis = new DataInputStream(socket.getInputStream());
                    String message = dis.readUTF()  + " 서버에서 다시 보낸 데이터";
                    dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(message);
                    dos.flush();
                    System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
                    socket.close();
                    System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 끊음");
                }
            }
            catch (IOException e) {
                System.out.println("[서버] " + e.getMessage());
            }

            try {
                if(dis !=null){
                    dis.close();
                }
                if(dos !=null){
                    dos.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        });
        thread.start();
    }


    private void stopServer() {
        try {
            serverSocket.close();
            System.out.println("[서버] 종료됨");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.run();
    }
}
