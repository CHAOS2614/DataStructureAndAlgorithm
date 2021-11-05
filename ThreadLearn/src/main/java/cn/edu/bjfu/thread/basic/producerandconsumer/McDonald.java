package cn.edu.bjfu.thread.basic.producerandconsumer;

/**
 * @author chaos
 * @date 2021-11-05 15:00
 */
public class McDonald {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public Chicken pop() {
        if (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (this) {
            Chicken chicken = chickens[--count];
            notifyAll();
            return chicken;
        }
    }

    public void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (this) {
            chickens[count++] = chicken;
            notifyAll();
        }
    }
}
