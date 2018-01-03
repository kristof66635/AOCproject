package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.GeneratorAsync;
import fr.istic.observer.ObserverGeneratorAsync;
import javafx.scene.control.Label;

import java.util.concurrent.Future;

public class Display implements ObserverGeneratorAsync {

    Canal canal;
    Future<Integer> future;
    Label lebel;

    public Display(Canal canal, Label lebel) {
        this.canal = canal;
        this.lebel = lebel;
    }


    /**
     * Client(display) appel le canal
     * @return Valeur futur
     */

    @Override
    public Future<Integer> getValueFuture() {
        System.out.println("Display.getValueFuture():Future");

        return canal.getValueFuture();

    }

    @Override
    public Future<Integer> update() {
        return null;
    }


}
