package j2lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String nick;
    String login;

    public ClientHandler(Server server, Socket socket) {
        try {
        this.server = server;
        this.socket = socket;
        in=new DataInputStream(socket.getInputStream());
        out=new DataOutputStream(socket.getOutputStream());

        new Thread(()-> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if(str.startsWith("/auth")){
                            String[]token=str.split(" ");
                            for(ClientHandler o:server.clients){
                                if(o.login.equals(token[1])){
                                    sendMsg("wrong login/password");
                                    return;
                                }
                            }
                            String newNick=AuthService.getNickByLoginAndPass(token[1],token[2]);
                            if (newNick != null) {
                                sendMsg("/authOk");
                                nick=newNick;
                                login=token[1];
                                server.subscribe(this);
                                break;
                            }else{
                                sendMsg("wrong login/password");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/end");
                            System.out.println("client is disconnect");
                            break;
                        }
                        if(str.startsWith("/w ")){
                            String[]token=str.split(" ");
                            for(ClientHandler o:server.clients){
                                if(o.nick.equals(token[1]))o.out.writeUTF(str);
                            }
                        }else {
                            System.out.println(str);
                            server.broadcastMsg(nick + ": " + str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    System.out.println("client is disconnect");
                }
        }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(String str){
        try {
            out.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
