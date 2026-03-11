package org.example.Apps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerApp {
    private final ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServerApp() throws IOException {
        this.serverSocket = new ServerSocket(59999);
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
            Socket socket = serverApp.accept();

            String str = "welcome";
            socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().write("\n".getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            byte[] buf = new byte[1024];
            int num = socket.getInputStream().read(buf);
            String msg = new String(buf);
            System.out.println(msg);

            serverApp.close();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
