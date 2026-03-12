package org.example.onebyone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    private final ServerSocket serverSocket;

    public ServerApp() throws IOException {
        this.serverSocket = new ServerSocket(59998);
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
            while (true) {
                Socket socket = serverApp.accept();

                new Thread(() -> {
                    try (
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                    ) {
                        dos.writeUTF("welcome");
                        dos.flush();

                        String msg = dis.readUTF();
                        System.out.println(msg);

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }).start();
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
