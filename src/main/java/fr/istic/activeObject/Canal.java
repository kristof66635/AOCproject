package fr.istic.activeObject;


import fr.istic.Display;
import fr.istic.observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Canal implements GeneratorAsync,ObserverGeneratorAsync {

    private int value;

    private List<ObserverGeneratorAsync> observers=new ArrayList<>();

    private ScheduledExecutorService scheduledExecutorService;
    private Generator generator;
    private Display display;

    public Canal(ScheduledExecutorService scheduledExecutorService, Generator generator) {
        this.scheduledExecutorService = scheduledExecutorService;
        this.generator = generator;
        this.display=new Display(this);
    }

    /**
     * Lancement asynchrone
     *
     */


    @Override
    public void execute() {

    }

    @Override
    public Integer getValue() {

        Callable<Integer> callable= this.generator::getValue;

        int random= (int)(Math.random()*1000);
        //System.out.println("random :"+random);

        Future<Integer> future= scheduledExecutorService.schedule(this.generator::getValue,random,TimeUnit.MILLISECONDS);
        Integer integer= null;

        try {
            integer = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException :"+e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException:"+e.getMessage());
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

        display.diplayGeneratedValue(generator.getValue());

       Runnable runnable= this.display::update;

        // callable = this.display::update;

        int random= (int)(Math.random()*1000);
        Future<Integer> future;
        future = (Future<Integer>) scheduledExecutorService.schedule(runnable,random, TimeUnit.MILLISECONDS);

    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

}
