package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;
import javafx.scene.control.Label;

public class Atomic implements Strategy {
    Generator generator;

    public Generator getGenerator() {
        return generator;
    }


    /**
     * La strategie Atomique
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
