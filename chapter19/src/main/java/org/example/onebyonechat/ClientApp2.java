package org.example.onebyonechat;

import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

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
        this.socket.connect(new InetSocketAddress("localhost",59997)); //진짜 접속
        this.dis = new DataInputStream(this.socket.getInputStream());
        this.dos = new DataOutputStream(this.socket.getOutputStream());
    }
    public void close() {
        try {
            dos.close();
        } catch (Exception e) {
        }
        try {
            dis.close();
        } catch (Exception e) {
        }
        try {
            this.socket.close();
        } catch (Exception e) {
        }
    }
    public String read(){
        String str = null;
        try {
            str = this.dis.readUTF();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-938);
        }
        return str;
    }

    public void send(Scanner scanner){
        try {
            StringBuilder str = new StringBuilder();
            String tmp;
            System.out.println("메시지를 보내고 싶으면 Z를 누른 후 엔터키를 누르세요.");
            do {
                tmp = scanner.nextLine();
                if (tmp.equals("Z")){
                    break;
                }
                str.append(tmp).append("\n");
            } while (true);

            this.dos.writeUTF(str.toString());
            this.dos.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ClientApp1 clientApp = null;
        try {
            clientApp = new ClientApp1();
            clientApp.connect();

            clientApp.send(scanner); //1.보내기

            String msg = clientApp.read(); //2.받기
            System.out.println("Server \n" + msg);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            clientApp.close();
            scanner.close();
        }
    }
}
