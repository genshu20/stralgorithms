package j2lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    Vector<ClientHandler>clients;

    public Server() {

        ServerSocket server=null;
        Socket socket=null;

        try {
            clients=new Vector<>();
            server=new ServerSocket(8189);
            System.out.println("the server is running");

            while(true){
                socket=server.accept();
                System.out.println("client is connected");
                clients.add(new ClientHandler(this,socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void broadcastMsg(String str){
        for(ClientHandler o:clients){
           o.sendMsg(str);
        }
    }
}
