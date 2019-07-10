package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller{
    @FXML
    public TextField textFild;
    @FXML
    public TextArea textArea;
    @FXML
    public Button button;
    @FXML
    public HBox upperPanel;
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public HBox bottomPanel;
    @FXML
    public ListView<String> clientList;

    private boolean isAuthorized;

    private boolean isTormoz;
    long x=System.currentTimeMillis();



    public void sendMsg(ActionEvent actionEvent) {
        try {
            out.writeUTF(textFild.getText());
            textFild.setText("");
            textFild.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Socket socket;
    DataOutputStream out;
    DataInputStream in;

    final String IP_ADRESS="localhost";
    final int PORT=8189;

    public void setAuthorized(boolean isAuthorized){
        this.isAuthorized=isAuthorized;
        if(isAuthorized){
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientList.setVisible(true);
            clientList.setManaged(true);

            Platform.runLater(()-> textFild.requestFocus());
        }else{
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientList.setVisible(false);
            clientList.setManaged(false);
        }
    }
    public void connect() {

        try {
            socket=new Socket(IP_ADRESS,PORT);
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());


            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {


                            while (System.currentTimeMillis()-x < 30000) {//сократил для ускорения проверки
                                String str = in.readUTF();
                                if (str.equals("/authOk")) {
                                    setAuthorized(true);
                                    textArea.clear();
                                    break;
                                }
                                textArea.appendText(str + "\n");
                            }
                            if(!isAuthorized){
                                socket.close();
                                isTormoz=true;
                            }



                    while (true){
                            String str=in.readUTF();
                            if(str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    System.out.println("client is disconnect");
                                    break;
                                }
                                if (str.startsWith("/clientlist")) {
                                    String[]token=str.split(" ");
                                    Platform.runLater(()-> {
                                        clientList.getItems().clear();
                                        for (int i = 1; i < token.length; i++) {
                                            clientList.getItems().add(token[i]);
                                        }
                                    });
                                }
                            }else textArea.appendText(str+"\n");
                        }
                    } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                        try{socket.close();}catch (IOException e){e.printStackTrace();}
                        setAuthorized(false);
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {
        if((socket==null||socket.isClosed())&&!isTormoz){

            connect();
        }
        try {
            out.writeUTF("/auth "+loginField.getText()+" "+passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickClientList(MouseEvent mouseEvent) {
        String receiver=clientList.getSelectionModel().getSelectedItem();
        textFild.setText("/w "+receiver+" ");
    }
}
