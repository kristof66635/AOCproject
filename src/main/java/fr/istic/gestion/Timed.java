package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;

/**
 * Does not work, using a sequential strategy
 *
 */
public class Timed  implements Strategy{
    private Generator generator;
    private int delay=500;

    public Timed(Generator generator) {
        this.generator = generator;
        generator.setStrategy(this);


    }

    public Timed(Generator generator, int delay) {
        this.generator = generator;
        generator.setStrategy(this);
        this.delay=delay;
    }


    @Override
    public void execute() {
        int i=0;
        for(Observer observer : generator.getObservers()){
            //observer.update();

            observer.update();
            //premier envoye ==premier affiche

        }

    }

    /**
     * @param current
     * @return vrai si la diffusion est terminé, faux sinon
     */
    @Override
    public boolean isDone(int current) {
        return false;
    }
}
