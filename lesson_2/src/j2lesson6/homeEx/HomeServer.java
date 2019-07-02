package j2lesson6.homeEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HomeServer {
    public static void main(String[] args) {
        ServerSocket server=null;
        Socket socket=null;

        try {
            server=new ServerSocket(8189);
            System.out.println("the server is running");
            socket=server.accept();
            System.out.println("client is connected");
            Scanner in=new Scanner(socket.getInputStream());
            Scanner sc=new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = sc.nextLine();
                        out.println(str);
                        if(str.equals("/end")) {
                            break;
                        }
                    }
                }
            }).start();
            while(true) {
                if (in.hasNextLine()) {
                    String str = in.nextLine();
                    if (str.equals("/end")) {
                        System.out.println("client is disconnect");
                        break;
                    }
                    System.out.println(str);
                }else break;
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
