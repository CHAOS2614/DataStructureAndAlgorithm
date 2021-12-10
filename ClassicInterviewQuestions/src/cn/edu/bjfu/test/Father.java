package cn.edu.bjfu.test;

/**
 * @author chaos
 * @date 2021-12-09 11:15
 */
public class Father {

    static int b = 10;

    public static class Person {
        public static void main(String[] args) {

        }
        public void test(){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }
    }

    public Father() {
        //n = 30;
    }

    static int n = 10;

    static {
        n = 20;
    }

    public static void main(String[] args) {
    }


}

interface Fly {


}

class Test {
    Father.Person person = new Father.Person();
}