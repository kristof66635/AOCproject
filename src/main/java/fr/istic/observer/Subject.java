package fr.istic.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {


    public void add(Observer o);

    public void delete(Observer o);

    public void execute();



}