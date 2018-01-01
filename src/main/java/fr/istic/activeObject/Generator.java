package fr.istic.activeObject;


import fr.istic.observer.Observer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Generator implements GeneratorAsync {

    private Integer value;
    private List<Observer<GeneratorAsync>> observers;

    public List<Observer<GeneratorAsync>> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer<GeneratorAsync>> observers) {
        this.observers = observers;
    }

    @Override
    public int getValue() {


        return value;

    }

    @Override
    public void add(Observer o) {
        if(!observers.contains(o))
            observers.add(o);

    }

    @Override
    public void delete(Observer o) {
        observers.remove(o);
    }


    @Override
    public void execute() {

    }
}
