package fr.istic.activeObject;


import fr.istic.Display;
import fr.istic.observer.Observer;
import fr.istic.observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Canal implements GeneratorAsync,ObserverGeneratorAsync {

    private int value;

    private List<ObserverGeneratorAsync> observers=new ArrayList<>();

    ScheduledExecutorService scheduledExecutorService;
    private Generator generator;
    private Display display;

    public Canal(ScheduledExecutorService scheduledExecutorService, Generator generator) {
        this.scheduledExecutorService = scheduledExecutorService;
        this.generator = generator;
    }

    /**
     * Lancement asynchrone
     * @return
     */


    @Override
    public void execute() {

    }
    @Override
    public Future<Integer> update() {
        System.out.println("Canal.update():Future");

        Callable<Integer> callable;
        callable = (Callable<Integer>)display.update();

        int random= (int)(Math.random()*100);
        Future<Integer> future= scheduledExecutorService.schedule(callable,random,TimeUnit.MILLISECONDS);

        return future;

    }

    @Override
    public Future<Integer> getValueFuture() {
        System.out.println("Canal.getValueFuture():Future");

        Callable<Integer> callable=null;
        callable= this.generator::getValue;
        int random= (int)(Math.random()*100);
        Future<Integer> future= scheduledExecutorService.schedule(callable,random,TimeUnit.MILLISECONDS);

        return future;
    }


    @Override
    public void add(ObserverGeneratorAsync o) {

    }

    @Override
    public void delete(ObserverGeneratorAsync o) {

    }


    @Override
    public Integer getValue() throws ExecutionException, InterruptedException {
        System.out.println("Canal.getValue():Future");

        return null;
    }
}
