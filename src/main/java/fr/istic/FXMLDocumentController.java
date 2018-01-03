package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.gestion.Strategy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    private Strategy strategyatomic;
    private Canal canal;
    private Display display;
    private Generator generator;







    @FXML
    private void start(ActionEvent event) {
        label.setText("Hello World!");
        scheduledExecutorService = new ScheduledThreadPoolExecutor(20);
        scheduledExecutorService.scheduleAtFixedRate(generator::createvalue,0,100, TimeUnit.MILLISECONDS);
        label.setText("");

    }
    @FXML
    private void stop(ActionEvent event) {
        label.setText("Goodbye World!");
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generator=new Generator();
        canal=new Canal(scheduledExecutorService,generator);
        display=new Display(canal,label);



    }

}

