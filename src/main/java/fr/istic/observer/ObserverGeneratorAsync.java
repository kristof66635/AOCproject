package fr.istic.observer;

import fr.istic.activeObject.GeneratorAsync;

import java.util.concurrent.Future;

/**
 * The observer for the Generator,for Asynchronous use
 */
public interface ObserverGeneratorAsync extends Observer<GeneratorAsync> {


    Future update() ;


}
