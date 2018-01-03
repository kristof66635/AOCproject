package fr.istic.gestion;

import fr.istic.activeObject.Canal;
import fr.istic.activeObject.Generator;
import fr.istic.observer.Observer;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Atomic implements Strategy {
    Generator generator;
    private List<Future> futures;


    public Atomic(Generator generator) {
        this.generator = generator;
        generator.setStrategy(this);
        futures=new ArrayList<>();

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
        System.out.println("Strategy.exec():");

        for(Observer observer : generator.getObservers()){
            //observer.update();
            Future<Integer> future = ((Canal)observer).update();


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
