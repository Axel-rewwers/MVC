package root.controllers;

public interface SwitchListener<T> {
    void switchObjects(T remove, T add);
}
