package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;

import java.util.concurrent.ExecutionException;

/**
 * Atomic strategy for managing the observers
 *
 */
public class Atomic implements Strategy {
    private Generator generator;


    public Atomic(Generator generator) {
        this.generator = generator;
        generator.setStrategy(this);

    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    /**
     * notify all observers
     *
     *
     */
    @Override
    public void execute() {
        //System.out.println("Strategy.exec():/*********** depart commencez");
        System.out.println("Using Atomic :");
        for(Observer observer : generator.getObservers()){
            //observer.update();
            try {
                observer.update().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        }
    }



    /**
     * @return vrai si la diffusion est terminé, faux sinon
     */
    @Override
    public boolean isDone(int current) {


            return false;

    }

}
