package fr.istic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 *
 * @author chak
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button stopButton;
    @FXML
    private Button startButton;
    public static ScheduledExecutorService scheduledExecutorService;
    @FXML
    private void start(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    @FXML
    private void stop(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Goodbye World!");
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        scheduledExecutorService = new ScheduledThreadPoolExecutor(20);
    }

}

