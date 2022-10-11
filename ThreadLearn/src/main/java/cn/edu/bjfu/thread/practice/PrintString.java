package cn.edu.bjfu.thread.practice;

/**
 * @author chaos
 * @date 2022-10-10 19:33
 */
public class PrintString {
    public static void main(String[] args) {
        StringPrint stringPrint = new StringPrint();
        new Thread(stringPrint::print, "A:").start();
        new Thread(stringPrint::print, "B:").start();
    }
}

class StringPrint {
    private String string = "hello world!";
    private int index = 0;

    public void print() {
        while (index < string.length()){
            synchronized (this) {
                notify();
                System.out.println(Thread.currentThread().getName() + string.charAt(index++));
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
