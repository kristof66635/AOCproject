package fr.istic;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.activeObject.GeneratorAsync;
import fr.istic.observer.ObserverGeneratorAsync;
import javafx.scene.control.Label;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Display implements ObserverGeneratorAsync {

    Canal canal;
    Future<Integer> future;
    Label lebel;

    public Display(Canal canal) {
        this.canal = canal;
    }

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

    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = new ScheduledThreadPoolExecutor(20);
        Canal canal;
         Display display;
         Generator generator;
        generator=new Generator();
        canal=new Canal(scheduledExecutorService,generator);
        display=new Display(canal);
        System.out.println("Display.getValueFuture():Future");
        scheduledExecutorService.scheduleAtFixedRate(generator::createvalue,0,100, TimeUnit.MILLISECONDS);


    }
}
