package j2lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        ServerSocket server=null;
        Socket socket=null;

        try {
            server=new ServerSocket(8189);
            System.out.println("the server is running");
            socket=server.accept();
            System.out.println("client is connected");
            Scanner in=new Scanner(socket.getInputStream());
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            while(true){
                String str=in.nextLine();
                if(str.equals("/end")){
                    System.out.println("client is disconnect");
                    break;
                }
                System.out.println(str);
                out.println("echo: "+str);
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
}
