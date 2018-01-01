package fr.istic.activeObject;


import fr.istic.observer.Observer;
import fr.istic.observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Canal implements GeneratorAsync {

    private int value;

    private List<ObserverGeneratorAsync> observers=new ArrayList<>();

    ScheduledExecutorService scheduledExecutorService;
    private Generator generator;

    public Canal(ScheduledExecutorService scheduledExecutorService, Generator generator) {
        this.scheduledExecutorService = scheduledExecutorService;
        this.generator = generator;
    }

    /**
     * Lancement asynchrone
     * @return
     */

    @Override
    public int getValue() throws ExecutionException, InterruptedException {
        Callable<Integer> callable=null;
        //callable = (Callable<Integer>)generator.getValue();

        int random= (int)(Math.random()*100);
        Future<Integer> future= scheduledExecutorService.schedule(callable,random,TimeUnit.MILLISECONDS);

    return (int)(future.get());

    }

    @Override
    public void add(Observer o) {
        //observers.add(o);
    }

    @Override
    public void delete(Observer o) {
        observers.remove(o);
    }

    @Override
    public void execute() {

    }
}
