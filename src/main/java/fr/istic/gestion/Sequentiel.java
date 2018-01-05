package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;

public class Sequentiel implements Strategy {

    private Generator generator;

    public Sequentiel(Generator generator) {
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
        System.out.println("Using Sequentiel :");

        for(Observer observer : generator.getObservers()){
            //observer.update();
            observer.update();


        }

    }


    /**
     * @return vrai si la diffusion est terminé, faux sinon
     */
    @Override
    public boolean isDone() {
        return false;
    }
}
