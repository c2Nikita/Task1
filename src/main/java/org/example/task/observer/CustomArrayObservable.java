package org.example.task.observer;

public interface CustomArrayObservable {

    void addObserver(CustomArrayObserver observer);
    void removeObserver(CustomArrayObserver observer);
    void notifyObservers();
}
