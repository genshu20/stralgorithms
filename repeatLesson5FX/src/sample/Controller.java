package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public TextField textField;
    @FXML
    public TextArea textArea;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Slider slider;
    @FXML
    public CheckBox checkBoxItalic;
    @FXML
    public CheckBox checkBoxBold;

    public void onMouseClickedbtn(MouseEvent mouseEvent) {
        System.out.println("onMouseClickedbtn");
    }

    public void onActiondbtn(ActionEvent actionEvent) {
        System.out.println("onActiondbtn");
    }

    public void onActionTextfield(ActionEvent actionEvent) {
        textArea.appendText(textField.getText()+"\n");
        textField.setText("");
    }

//    public void onActionColorPicker(ActionEvent actionEvent) {
//        System.out.println(colorPicker.getValue());
//        String color=colorPicker.getValue().toString();
//        color="#"+color.substring(2,8);
//        System.out.println(color);
//
//        textArea.setStyle("-fx-text-fill: darkgreen;"+"-fx-control-inner-background:"+color+";"
//        +"-fx-highlight-fill: red;"+"-fx-highlight-text-fill: yellow;");
//    }

//    public void onMouseReleasedSlider(MouseEvent mouseEvent) {
//        textArea.setStyle("-fx-font-size: "+(int)slider.getValue()+"px");
//    }

//    public void onActionCheckBox(ActionEvent actionEvent) {
//        if(checkBoxBold.isSelected())textArea.setStyle("-fx-font-weight: bold");
//        if(checkBoxItalic.isSelected())textArea.setStyle("-fx-font-style: italic");
//        if(!checkBoxItalic.isSelected()&&!checkBoxBold.isSelected())textArea.setStyle("-fx-font-style: normal");
    //}

//    public void tuning(ActionEvent actionEvent){
//        System.out.println(colorPicker.getValue());
//        String color=colorPicker.getValue().toString();
//        color="#"+color.substring(2,8);
//        System.out.println(color);
//        String s="-fx-text-fill: darkgreen;"+"-fx-control-inner-background:"+color+";"
//                +"-fx-highlight-fill: red;"+"-fx-highlight-text-fill: yellow;"+"-fx-font-size: "+(int)slider.getValue()+"px"+";";
//
//        if(checkBoxBold.isSelected())textArea.setStyle("-fx-font-weight: bold"+s);
//        if(checkBoxItalic.isSelected())textArea.setStyle("-fx-font-style: italic"+s);
//        if(!checkBoxItalic.isSelected()&&!checkBoxBold.isSelected())textArea.setStyle("-fx-font-style: normal"+s);
//    }
    public void tuning(MouseEvent actionEvent){
        System.out.println(colorPicker.getValue());
        String color=colorPicker.getValue().toString();
        color="#"+color.substring(2,8);
        System.out.println(color);
        String s="-fx-text-fill: darkgreen;"+"-fx-control-inner-background:"+color+";"
                +"-fx-highlight-fill: red;"+"-fx-highlight-text-fill: yellow;"+"-fx-font-size: "+(int)slider.getValue()+"px"+";";

        if(checkBoxBold.isSelected())textArea.setStyle(s+"-fx-font-weight: bold");
        if(checkBoxItalic.isSelected())textArea.setStyle(s+"-fx-font-style: italic");
        if(!checkBoxItalic.isSelected()&&!checkBoxBold.isSelected())textArea.setStyle(s+"-fx-font-style: normal");
    }
}
