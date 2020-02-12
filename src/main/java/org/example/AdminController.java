package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.example.Controller.MainController;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    MainController mainController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainController = new MainController(this);
    }
    public void handleStartService(ActionEvent event){
        System.out.println("Welcome ");
        mainController.createRegistry();
    }

}
