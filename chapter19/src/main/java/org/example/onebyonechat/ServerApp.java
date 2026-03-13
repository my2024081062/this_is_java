package org.example.onebyonechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerApp {
    private final ServerSocket serverSocket;

    public ServerApp() throws IOException {
        this.serverSocket = new ServerSocket(59997);
    }

    public Socket accept() throws IOException{
        return this.serverSocket.accept();
    }

    public void close() throws IOException{
        this.serverSocket.close();
    }
    public static void main(String[] args){
        try {
            ServerApp serverApp = new ServerApp();
            AtomicBoolean nonQuit = new AtomicBoolean(true);
            while (nonQuit.get()) {
                Socket socket = serverApp.accept();
                Scanner scanner = new Scanner(System.in);

                new Thread(() -> {
                    // 익명 쓰레드에서 메인의 변수를 못 사용 하는 이유: 메인이 다 끝나고 실행 될 수 있기 때문에
                    // final로 만들어서 종료되어도 메모리에 남아 있게해야함.
                    try (
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    ) {
                        String msg = dis.readUTF(); // 2.받기
                        System.out.println("Client \n" + msg);

                        StringBuilder str = new StringBuilder();
                        String tmp;
                        System.out.println("메시지를 보내고 싶으면 Z를 누른 후 엔터키를 누르세요.");
                        do {
                            tmp = scanner.nextLine();
                            if (tmp.equals("Z")){
                                break;
                            }
                            if(tmp.equals("Q")){
                                nonQuit.set(false);
                                break;
                            }
                            str.append(tmp).append("\n");
                        } while (true);
                        dos.writeUTF(str.toString()); //1.보내기
                        dos.flush();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }).start();
            }
            serverApp.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
