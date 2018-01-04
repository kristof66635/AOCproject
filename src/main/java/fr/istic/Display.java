package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.observer.ObserverGeneratorAsync;
import javafx.scene.control.Label;

public class Display implements ObserverGeneratorAsync {

    Canal canal;
    Integer integer;
    Label label;

    public Display(Canal canal,Label label) {
        this.canal = canal;
        this.label=label;
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
        //Platform.runLater(() -> label.setText("New value :"+integer));
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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
}
