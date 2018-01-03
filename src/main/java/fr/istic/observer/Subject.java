package fr.istic.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {


    public void add(ObserverGeneratorAsync o);

    public void delete(ObserverGeneratorAsync o);

    public void execute();



}