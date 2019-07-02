package j2lesson6.homeEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    final static String IP_ADRESS="localhost";
    final static int PORT=8189;

    public static void main(String[] args) {
        Socket socket=null;
        try {
             socket=new Socket(IP_ADRESS,PORT);
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
            while(true){
                if (in.hasNextLine()) {
                String str=in.nextLine();
                if(str.equals("/end")){
                    System.out.println("server is disconnect");
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

        }
    }
}