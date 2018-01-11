package fr.istic.gestion;

/**
 * Strategy for managing the observers
 */
public interface Strategy {

    public void execute() ;



    /**
     *
     * @return vrai si la diffusion est terminé, faux sinon
     */
    boolean isDone(int current);

}
