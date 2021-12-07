package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2021-12-06 23:27
 */
public class test1 {
    public static void main(String[] args) {
        MyResources myResources = new MyResources();
        new Thread(() -> myResources.printNumber(), "number").start();
        new Thread(() -> myResources.printChar(), "number").start();
    }


}


class MyResources {

    boolean isNumber = true;

    public synchronized void printNumber() {
        for (int i = 0; i < 26; ) {
            while (!isNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(++i);
            isNumber = false;
            notify();
        }
    }

    public synchronized void printChar() {
        for (int i = 0; i < 26; i++) {
            while (isNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println((char) (i + 'a'));
            isNumber = true;
            notify();
        }
    }

}
