package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;

public class Sequentiel implements Strategy {

    private Generator generator;

    public Sequentiel(Generator generator) {
        this.generator = generator;
    }

    public Generator getGenerator() {
        return generator;
    }

    /**
     * La strategie sequentielle
     *
     *
     */
    @Override
    public void execute() {
        for(Observer s : generator.getObservers()){
            s.update(generator);

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
