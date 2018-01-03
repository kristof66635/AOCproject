package fr.istic.gestion;

import fr.istic.activeObject.Generator;
import javafx.scene.control.Label;

public interface Strategy {

    public void execute();



    /**
     *
     * @return vrai si la diffusion est terminé, faux sinon
     */
    boolean isDone();

}
