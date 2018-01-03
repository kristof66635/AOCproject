package fr.istic.observer;

import fr.istic.activeObject.GeneratorAsync;

import java.util.concurrent.Future;

public interface ObserverGeneratorAsync extends Observer<GeneratorAsync> {

    Future<Integer> getValueFuture();

    Future<Integer> update();


}
