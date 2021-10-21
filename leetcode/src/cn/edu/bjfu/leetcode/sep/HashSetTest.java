package cn.edu.bjfu.leetcode.sep;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author chaos
 * @date 2021-09-27 23:28
 */
public class HashSetTest {

    @Test
    public void test1(){
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        set.remove(p1);
        // 删除的时候是根据hash值进行删除的，但是p1的hash值已经变了，所以实际上没有删除
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        // add的时候是根据hash值进行删除的，原来p1的hash值是根据“AA”算的，所以存储地址与原来的p1不同AA
        // set.remove(p1);删除的是第二次加入的CC
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        // hash值一样，但是equals()返回false，会存储
        System.out.println(set);

    }

}

class Person {

    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (age != person.age) {
            return false;
        }
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
