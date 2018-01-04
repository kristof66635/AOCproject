package fr.istic.activeObject;


import fr.istic.Display;
import fr.istic.observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
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
        this.display=new Display(this);
    }

    /**
     * Lancement asynchrone
     * @return
     */


    @Override
    public void execute() {

    }

    @Override
    public Integer getValue() {

        Callable<Integer> callable= this.generator::getValue;

        int random= (int)(Math.random()*1000);
        //System.out.println("5555555555555555555555random"+random);

        Future<Integer> future= scheduledExecutorService.schedule(this.generator::getValue,random,TimeUnit.MILLISECONDS);
        Integer integer= null;

        try {
            integer = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("getValue():"+integer);

        return integer ;
    }


    @Override
    public void add(ObserverGeneratorAsync o) {

    }

    @Override
    public void delete(ObserverGeneratorAsync o) {

    }


    @Override
    public void update()  {

       Runnable callable= this.display::update;

        // callable = this.display::update;

        int random= (int)(Math.random()*100);
        Future<Integer> future= (Future<Integer>) scheduledExecutorService.schedule(callable,random,TimeUnit.MILLISECONDS);

    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

}
