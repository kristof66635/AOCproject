package fr.istic.gestion;

public interface Strategy {

    public void execute() ;



    /**
     *
     * @return vrai si la diffusion est terminé, faux sinon
     */
    boolean isDone();

}
