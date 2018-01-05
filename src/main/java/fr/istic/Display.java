package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.observer.ObserverGeneratorAsync;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Display implements ObserverGeneratorAsync {

    private Canal canal;
    private Integer integer;
    private Label labelDis;
    private Label labelGen;

    public Display(Canal canal,Label labelDis) {
        this.canal = canal;
        this.labelDis = labelDis;
    }

    public Display(Canal canal) {
        this.canal = canal;
    }

    /**
     * Client(display) appel le canal
     * @return Valeur futur
     */
    @Override
    public void update() {
        //future =canal.getValue();

        integer=canal.getValue();


        System.out.println("update(): "+integer+" Fin.");
        Platform.runLater(() -> labelDis.setText(String.valueOf(integer)));
    }

    public void diplayGeneratedValue(Integer integer){

        Platform.runLater(() -> labelGen.setText(String.valueOf(integer)));


    }




/*
    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
        Canal canal;
        Generator generator;
        generator=new Generator();
        canal=new Canal(scheduledExecutorService,generator);
        Display display=new Display(canal);
        Strategy strategy=new Atomic(generator);
        generator.add(canal);
        //System.out.println("Display.getValueFuture():Future");
        scheduledExecutorService.scheduleAtFixedRate(generator::createvalue,0,3000, TimeUnit.MILLISECONDS);


    }
*/

    public Label getLabelDis() {
        return labelDis;
    }

    public void setLabelDis(Label labelDis) {
        this.labelDis = labelDis;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public Label getLabelGen() {
        return labelGen;
    }

    public void setLabelGen(Label labelGen) {
        this.labelGen = labelGen;
    }
}
