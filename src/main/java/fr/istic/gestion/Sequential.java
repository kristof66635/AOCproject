package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;

/**
 * Sequential strategy for managing the observers
 */
public class Sequential implements Strategy {

    private Generator generator;

    public Sequential(Generator generator) {
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
     * notify all observers with a timed interva
     *
     *
     */
    @Override
    public void execute() {
        System.out.println("Using Sequential :");
        for(Observer observer : generator.getObservers()){

            observer.update();

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
