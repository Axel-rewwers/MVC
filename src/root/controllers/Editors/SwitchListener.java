package root.controllers.Editors;

public interface SwitchListener<T> {
    void switchObjects(T remove, T add);
}
