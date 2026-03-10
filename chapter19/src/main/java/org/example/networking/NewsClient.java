package org.example.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class NewsClient {
    public void run(){
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String data = "정치";
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);

            DatagramPacket sendPacket = new DatagramPacket(
                bytes
                ,bytes.length
                ,new InetSocketAddress("localhost"
                ,50001));
            datagramSocket.send(sendPacket);

            while (true){
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
                datagramSocket.receive(receivePacket);

                String news = new String(
                    receivePacket.getData()
                    ,0
                    ,receivePacket.getLength()
                    ,StandardCharsets.UTF_8);
                System.out.println(news);

                if(news.equals("뉴스10")){
                    break;
                }
            }
            datagramSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        NewsClient newsClient = new NewsClient();
        newsClient.run();
    }
}
