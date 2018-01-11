package fr.istic.activeObject;


import fr.istic.Display;
import fr.istic.observer.ObserverGeneratorAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * The canal (Proxy) for the two calls
 */
public class Canal implements GeneratorAsync,ObserverGeneratorAsync {

    private int value;

    private List<ObserverGeneratorAsync> observers=new ArrayList<>();

    private ScheduledExecutorService scheduledExecutorService;
    private Generator generator;
    private Display display;
    private int ranks=0;


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

        //rank*1000000+getvaleu


        int random= (int)(Math.random()*1000);

        Callable<Integer> callable = this.generator::getValue;

        //System.out.println("random :"+random);

        Future<Integer> future= scheduledExecutorService.schedule(callable,random,TimeUnit.MILLISECONDS);
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




    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }



    @Override
    public Future update() {
        int random= (int)(Math.random()*1000);
        display.diplayGeneratedValue(generator.getValue());

        Runnable runnable= this.display::update;

        // callable = this.display::update;

        System.out.println("random :"+random);

        Future<Integer> future;
        future = (Future<Integer>) scheduledExecutorService.schedule(runnable,random, TimeUnit.MILLISECONDS);

        return future;    }
}
