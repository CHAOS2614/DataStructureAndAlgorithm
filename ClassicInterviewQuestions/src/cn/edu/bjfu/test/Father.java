package cn.edu.bjfu.test;

import java.util.Scanner;

/**
 * @author chaos
 * @date 2021-12-09 11:15
 */
public class Father {

    static int b = 10;
    int a = 1;

    public static class Person {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < chars.length; ) {
                int count = 1;
                while (++i < chars.length && chars[i] == chars[i - 1]) {
                    count++;
                }
                if (count == 1) {
                    stringBuilder.append(chars[i - 1]);
                } else {
                    stringBuilder.append(chars[i - 1]).append(count);
                }
            }
            System.out.println(stringBuilder);


            Father father = new Father();
            Person person = new Person();
            person.test1(father);
            System.out.println(father.a);
            Class<Father> fatherClass = Father.class;
        }

        public void test() {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
        }

        public void test1(Father father) {
            father = new Father();
            father.a = 2;
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
        System.out.println('\u0000');
        Integer integer = 1;
        Integer i = new Integer(126);
        Integer i2 = new Integer(126);
        System.out.println(i == i2);
        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);


    }


}

interface Fly {


}

class Test {
    Father.Person person = new Father.Person();
}

class Son extends Father {
    public void privateTest() {
        System.out.println("a");
    }
}