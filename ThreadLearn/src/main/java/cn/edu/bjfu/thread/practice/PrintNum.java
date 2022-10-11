package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2022-10-06 10:11
 *
 * 两个线程轮流打印数字，一直到100
 */
public class PrintNum {

    private static boolean isSingular = true;
    public static int num = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (Object.class) {
                for (int i = 0; i < 50; i++) {
                    while (!isSingular) {
                        try {
                            Object.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("单数: " + num++);
                    isSingular = !isSingular;
                    Object.class.notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (Object.class) {
                for (int i = 0; i < 50; i++) {
                    while (isSingular) {
                        try {
                            Object.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("双数: " + num++);
                    isSingular = !isSingular;
                    Object.class.notify();
                }
            }
        }).start();
    }
}
