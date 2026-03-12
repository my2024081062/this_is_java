package org.example.onebyone;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Getter
@Setter
public class ClientApp2 {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    public ClientApp2() throws IOException {
        this.socket = new Socket(); //통신

    }
    public void connect() throws IOException {
//        this.socket.bind(new InetSocketAddress("localhost",59999)); //ip와 포트 정보를 묶음
        this.socket.connect(new InetSocketAddress("localhost",59998)); //진짜 접속
        this.dis = new DataInputStream(this.socket.getInputStream());
        this.dos = new DataOutputStream(this.socket.getOutputStream());
    }
    public void close() throws IOException {
        dos.close();
        dis.close();
        this.socket.close();
    }
    public String read(){
        String str = null;
        try {
            str = this.dis.readUTF();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return str;
    }

    public void send(String msg){
        try {
            this.dos.writeUTF(msg);
            this.dos.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            ClientApp2 clientApp = new ClientApp2();
            clientApp.connect();

            String msg = clientApp.read();
            System.out.println("Server: " + msg);

            clientApp.send(clientApp + " 접속 했습니다.");

            clientApp.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
