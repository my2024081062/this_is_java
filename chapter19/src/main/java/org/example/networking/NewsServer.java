package org.example.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NewsServer {
    private static DatagramSocket datagramSocket = null;
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
        Thread thread = new Thread(()->{
           try {
               datagramSocket = new DatagramSocket(50001);
               System.out.println("[서버] 시작됨");
               while (true){
                   DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
                   datagramSocket.receive(receivePacket);
                   String newsKind =
                       new String(receivePacket.getData(),0,receivePacket.getLength(), StandardCharsets.UTF_8);
                   SocketAddress socketAddress = receivePacket.getSocketAddress();

                   for(int i = 0; i <= 10; i++){
                       String data = newsKind + ": 뉴스" + i;
                       byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
                       DatagramPacket sendPacket =
                           new DatagramPacket(bytes,0,bytes.length,socketAddress);
                       datagramSocket.send(sendPacket);
                   }
               }
           } catch (IOException e) {
               System.out.println("[서버] " + e.getMessage());
           }
        });
        thread.start();
    }
    private void stopServer() {
        datagramSocket.close();
        System.out.println("[서버] 종료됨");
    }
    public static void main(String[] args){
        NewsServer newsServer = new NewsServer();
        newsServer.run();
    }
}
