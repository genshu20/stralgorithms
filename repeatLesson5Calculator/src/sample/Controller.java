package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    char znak=' ';
    double memory=0;
    @FXML
    public TextField textField;

    public void pressPlus(ActionEvent actionEvent) {
        znak='+';
        memory=readDoubleFromTextField();
        textField.setText("");
        textField.requestFocus();
    }

    public void pressMinus(ActionEvent actionEvent) {
        znak='-';
        memory=readDoubleFromTextField();
        textField.setText("");
        textField.requestFocus();
    }

    public void pressCalc(ActionEvent actionEvent) {
        double num=readDoubleFromTextField();
        if(znak=='+')memory+=num;
        if(znak=='-')memory-=num;
        textField.setText(""+memory);
    }

    public void pressClear(ActionEvent actionEvent) {
        textField.setText("");
        memory=0;
    }
    private double readDoubleFromTextField(){
        try{
            return Double.parseDouble(textField.getText());
        }catch (NumberFormatException e) {return 0;}
    }
}
