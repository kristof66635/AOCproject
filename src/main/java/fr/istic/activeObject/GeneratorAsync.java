package fr.istic.activeObject;

import fr.istic.observer.Subject;

import java.util.concurrent.ExecutionException;


public interface GeneratorAsync extends Subject {

    Integer getValue() throws ExecutionException, InterruptedException;

}
