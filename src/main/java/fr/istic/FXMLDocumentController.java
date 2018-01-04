package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.gestion.Atomic;
import fr.istic.gestion.Strategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


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
        scheduledExecutorService = new ScheduledThreadPoolExecutor(7);
        generator=new Generator();
        canal=new Canal(scheduledExecutorService,generator);
        strategyatomic=new Atomic(generator);
        generator.add(canal);
        //System.out.println("Display.getValueFuture():Future");
        scheduledExecutorService.scheduleAtFixedRate(generator::createvalue,0,3000, TimeUnit.MILLISECONDS);


    }
    @FXML
    private void stop(ActionEvent event) {

        scheduledExecutorService.shutdown();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO




    }

}

