package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.gestion.Atomic;
import fr.istic.gestion.Sequentiel;
import fr.istic.gestion.Strategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    private Label labelDis;
    @FXML
    private Label labelDis1;

    @FXML
    private Label labelGen;

    @FXML
    RadioButton radioAtomic;
    @FXML
    RadioButton radioSequentiel;
    @FXML
    private Button stopButton;
    @FXML
    private Button startButton;

    public static ScheduledExecutorService scheduledExecutorService;
    private Strategy strategy;
    private Canal canal1,canal2;

    private Generator generator;
    final ToggleGroup group = new ToggleGroup();






    @FXML
    private void start(ActionEvent event) {
        startButton.setDisable(true);
        scheduledExecutorService = new ScheduledThreadPoolExecutor(7);
        generator=new Generator();
        canal1=new Canal(scheduledExecutorService,generator);
        canal2=new Canal(scheduledExecutorService,generator);

        if(radioAtomic.isSelected()){
            strategy =new Atomic(generator);

        }else{
            strategy =new Sequentiel(generator);
        }
        generator.add(canal1);
        generator.add(canal2);
        canal1.getDisplay().setLabelDis(labelDis);
        canal2.getDisplay().setLabelDis(labelDis1);
        canal1.getDisplay().setLabelGen(labelGen);
        canal2.getDisplay().setLabelGen(labelGen);
        //System.out.println("Display.getValueFuture():Future");
        scheduledExecutorService.scheduleAtFixedRate(generator::createvalue,0,3000, TimeUnit.MILLISECONDS);


    }
    @FXML
    private void stop(ActionEvent event) {
        startButton.setDisable(false);
        scheduledExecutorService.shutdown();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioAtomic.setToggleGroup(group);
        radioSequentiel.setToggleGroup(group);

        radioAtomic.setSelected(true);

    }


}

