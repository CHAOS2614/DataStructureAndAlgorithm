package cn.edu.bjfu.pattern.observer;

/**
 * @author chaos
 * @date 2022-09-22 21:27
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
