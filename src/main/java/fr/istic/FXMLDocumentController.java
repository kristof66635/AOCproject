package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.gestion.Atomic;
import fr.istic.gestion.Sequential;
import fr.istic.gestion.Strategy;
import fr.istic.gestion.Timed;
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
 *The FX controller class
 * @author chak
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelDis1,labelDis2,labelDis3,labelDis4,labelDis5,labelDis6;

    @FXML
    private Label labelGen;

    @FXML
    RadioButton radioAtomic, radioSequential,radioTimed;
    @FXML
    private Button startButton,stopButton;

    public static ScheduledExecutorService scheduledExecutorService;
    private Strategy strategy;
    private Canal canal1,canal2,canal3,canal4,canal5,canal6;

    private Generator generator;
    final ToggleGroup group = new ToggleGroup();

    private boolean run=false;
    /**
     * method to start the UI and launch the generator
     * @param event
     */


    @FXML
    private void start(ActionEvent event) {
        if(!run) {
            scheduledExecutorService = new ScheduledThreadPoolExecutor(7);
            generator = new Generator();
            canal1 = new Canal(scheduledExecutorService, generator);
            canal2 = new Canal(scheduledExecutorService, generator);
            canal3 = new Canal(scheduledExecutorService, generator);
            canal4 = new Canal(scheduledExecutorService, generator);
            canal5 = new Canal(scheduledExecutorService, generator);
            canal6 = new Canal(scheduledExecutorService, generator);


            if (radioAtomic.isSelected()) {
                strategy = new Atomic(generator);

            } else {
                if (radioTimed.isSelected()) {
                    strategy = new Timed(generator,1000);

                } else {
                    strategy = new Sequential(generator);

                }
            }
            generator.add(canal1);
            generator.add(canal2);
            generator.add(canal3);
            generator.add(canal4);
            generator.add(canal5);
            generator.add(canal6);

            canal1.getDisplay().setLabelDis(labelDis1);
            canal2.getDisplay().setLabelDis(labelDis2);
            canal3.getDisplay().setLabelDis(labelDis3);
            canal4.getDisplay().setLabelDis(labelDis4);
            canal5.getDisplay().setLabelDis(labelDis5);
            canal6.getDisplay().setLabelDis(labelDis6);

            canal1.getDisplay().setLabelGen(labelGen);
            canal2.getDisplay().setLabelGen(labelGen);
            canal3.getDisplay().setLabelGen(labelGen);
            canal4.getDisplay().setLabelGen(labelGen);
            canal5.getDisplay().setLabelGen(labelGen);
            canal6.getDisplay().setLabelGen(labelGen);


            //System.out.println("Display.getValueFuture():Future");
            scheduledExecutorService.scheduleAtFixedRate(generator::createvalue, 0, 3000, TimeUnit.MILLISECONDS);
            run=true;
        }
    }
    @FXML
    private void stop(ActionEvent event) {
        if(run){
            scheduledExecutorService.shutdown();
            run=false;

        }
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioAtomic.setToggleGroup(group);
        radioSequential.setToggleGroup(group);
        radioTimed.setToggleGroup(group);

        radioAtomic.setSelected(true);

    }


}

