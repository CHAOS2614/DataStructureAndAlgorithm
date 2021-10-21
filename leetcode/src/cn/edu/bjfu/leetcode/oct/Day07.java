package cn.edu.bjfu.leetcode.oct;

import org.junit.Test;

import java.util.*;


/**
 * @author chaos
 * @date 2021-10-07 11:02
 */
public class Day07 {

    public static int a = 10;
    public int b = 20;


    @Test
    public void floatNaNTest() {

        float f1 = 0.0f / 0.0f;
        float f2 = 5.0f / 0.0f;
        float f3 = 6.0f / 0.0f;
        float f4 = 6.0f / 0.0f;

        System.out.println(f1);
        System.out.println(f2);

        System.out.println(Float.isInfinite(f1));   // false
        System.out.println(Float.isInfinite(f2));   // true

        System.out.println(Float.isNaN(f1));    // true
        System.out.println(Float.isNaN(f2));    // false

        System.out.println(f1 == f2);   // false
        System.out.println(f2 == f3);   // true
        System.out.println(f3 == f4);   // true
    }

    @Test
    public void hashMapTest() {

        Map<String, String> map = new HashMap<>();
        Hashtable<String, Object> objectObjectHashtable = new Hashtable<>();
        map.put(null, null);
        // 运行时报错
        // objectObjectHashtable.put("name", null);
        // objectObjectHashtable.put("age", null);
        for (String o : objectObjectHashtable.keySet()) {
            System.out.println(objectObjectHashtable.get(o));
        }

        Map<String, String> map1 = Collections.synchronizedMap(map);

        HashMap<String, String> stringHashMap = new HashMap<>(7);
        stringHashMap.put("name", "chaos");
        for (String s : stringHashMap.keySet()) {
            System.out.println(stringHashMap.get(s));
        }


    }

    @Test
    public void ArrayListTest() throws NullPointerException {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        throw new NullPointerException();
    }

    @Test
    public void FloatTest() {
        System.out.println(Float.MAX_VALUE);
    }

    @Test
    public void compareTest(){
        TreeMap<String,String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        map.put("b","sdfwe");
        map.put("c","faddf");
        map.put("a","adsfsdf");
        map.forEach((k,v) -> System.out.println(k + v));

    }


}


class BaseClass{
    private int a = 10;
    void soutA(){
        System.out.println(this.a);
    }
}

class SubClass extends  BaseClass{
    int a = 20;
    void souta2(){
        System.out.println(a);
        super.soutA();
    }

    public static void main(String[] args) {
        new SubClass().soutA();
        new SubClass().souta2();
    }
}

interface Fly{
    public int A = 10;
}

