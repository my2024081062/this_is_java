package org.example.networking;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class EchoServer {
    private static ServerSocket serverSocket = null;
    private static ExecutorService executorService =
        Executors.newFixedThreadPool(10);
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

        AtomicReference<DataInputStream> dis = new AtomicReference<>();
        AtomicReference<DataOutputStream> dos = new AtomicReference<>();
        AtomicReference<InetSocketAddress> isa = new AtomicReference<>();
        final Socket[] socket = {null};
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨");
                    while (true){
                        socket[0] = serverSocket.accept();
                        executorService.execute(()->{
                            try {
                                isa.set((InetSocketAddress) socket[0].getRemoteSocketAddress());
                                System.out.println("[서버] " + isa.get().getHostString() + "의 연결 요청을 수락함");
                                // 클라이언트 요청 처리
                                // 데이터 받기

                                dis.set(new DataInputStream(socket[0].getInputStream()));
                                String message = dis.get().readUTF()  + " 서버에서 다시 보낸 데이터";
                                dos.set(new DataOutputStream(socket[0].getOutputStream()));
                                dos.get().writeUTF(message);
                                dos.get().flush();
                                System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
                            }
                            catch (IOException ignored){

                            }
                            finally {
                                try {
                                    dis.get().close();
                                    dos.get().close();
                                    socket[0].close();
                                    System.out.println("[서버] " + isa.get().getHostString() + "의 연결 요청을 끊음");
                                }
                                catch (Exception e){

                                }
                            }
                        });
                    }
                }
                catch (IOException e) {
                    System.out.println("[서버] " + e.getMessage());
                }
            }
        };
        thread.start();
    }


    private void stopServer() {
        try {
            serverSocket.close();
            executorService.shutdown();
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
