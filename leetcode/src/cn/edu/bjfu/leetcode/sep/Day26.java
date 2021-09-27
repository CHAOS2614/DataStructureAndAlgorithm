package cn.edu.bjfu.leetcode.sep;

import java.util.Arrays;

/**
 * @author chaos
 * @date 2021-09-25 13:06
 */
public class Day26 {

    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Object i = 1;
        System.out.println(i);
    }

    public void sort(int[] a) {
        Arrays.sort(a);
    }

}

class Creature {
    public Creature() {
        System.out.println("Creature无参数的构造器");
    }
}

class Animal2 extends Creature {
    public Animal2(String name) {
        System.out.println("Animal带一个参数的构造器，该动物的name为" + name);
    }

    public Animal2(String name, int age) {
        this(name);
        System.out.println("Animal带两个参数的构造器，其age为" + age);
    }
}

class Wolf extends Animal2 {
    public Wolf() {
        super("灰太狼", 3);
        System.out.println("Wolf无参数的构造器");
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        long l = 10L;
    }

}

class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class FieldMethodTest {
    public static void main(String[] args) {
        // 20
        Sub s = new Sub();
        System.out.println(s.count);
        System.out.println(s);
        System.out.println(s);
        System.out.println(((Base) s).count);
        char[] arr = new char[]{'a', 'b', 'c'};
        // abc
        System.out.println(arr);
        int[] arr1 = new int[]{1, 2, 3};
        //地址
        System.out.println(arr1);
        double[] arr2 = new double[]{1.1, 2.2, 3.3};
        // 地址
        System.out.println(arr2);

        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//

        Integer i = 1;
        System.out.println(i);


    }
}

class Sub extends Base {
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }

    public void addOne(final Other o) {
        // o = new Other(); 不能再次复制
        o.i++;
    }
}

class Other {
    public int i;
}

class Outer {
    private int s;
    public class Inner {
        public void mb() {
            s = 100;
            System.out.println("在内部类Inner中s=" + s);
        }
    }
    public void ma() {
        Inner i = new Inner();
        i.mb();
    }
}
class InnerTest {
    public static void main(String args[]) {
        Outer o = new Outer();
        o.ma();
    }
}

class Test {
    public Test() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        s2.a = 20;
        Test.Inner s3 = new Test.Inner();
        System.out.println(s2.a);
    }
    class Inner {
        public int a = 5;
    }
    public static void main(String[] args) {
        Test t = new Test();
        Inner r = t.new Inner();
        System.out.println(r.a);
    }
}