package org.example.Apps;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientApp {
    private Socket socket;
    public ClientApp() throws IOException {
        this.socket = new Socket(); //통신

    }
    public void connect() throws IOException {
//        this.socket.bind(new InetSocketAddress("localhost",59999)); //ip와 포트 정보를 묶음
        this.socket.connect(new InetSocketAddress("localhost",59999)); //진짜 접속
    }
    public void close() throws IOException {
        this.socket.close();
    }
    public String read(){
        String str = null;
        try {
            byte[] buf = new byte[1024];
            int num = this.socket.getInputStream().read(buf);
            str = new String(buf,0,num,StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return str;
    }

    public void send(String msg){
        try {
            byte[] buf = msg.getBytes(StandardCharsets.UTF_8);
            this.socket.getOutputStream().write(buf);
            this.socket.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void main(String[] args){
        try {
            ClientApp clientApp = new ClientApp();
            clientApp.connect();

            String msg = clientApp.read();
            System.out.println("Server: " + msg);

            clientApp.send("접속 했습니다.");

            clientApp.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
