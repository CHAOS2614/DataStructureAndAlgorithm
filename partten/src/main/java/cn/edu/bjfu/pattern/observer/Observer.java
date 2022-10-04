package cn.edu.bjfu.pattern.observer;

/**
 * @author chaos
 * @date 2022-09-22 21:25
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
