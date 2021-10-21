package cn.edu.bjfu.leetcode.oct;


/**
 * @author chaos
 * @date 2021-10-08 12:29
 */
public class Day08 {

    public static void main(String[] args) throws CloneNotSupportedException {
        String s = "s";
        String s1 = "s";
        String s2 = new String("s");
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s.getClass().getClassLoader());
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        Person person = new Person();
        Person clone = (Person) person.clone();
        System.out.println(person == clone);
        System.out.println(person.getPerson() == clone.getPerson());
        System.out.println(person.getAge() == clone.getAge());

    }
}

class Person implements Cloneable {
    int age = 2;
    String name;
    Person person;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

}


class BaseClass1 {
    private void get() {
        System.out.println(1);
    }

    public static void add() {
        System.out.println(3);
    }
}

class SubC extends BaseClass1 {
    void get() {
        System.out.println(2);

    }

}

class B3
{
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    // 静态域的执行顺序和代码位置前后有关 所以加载类时先输出静态块
    // 如果将这两个变量放在静态块之前，则结果是 构 构 静 构，因为先初始化t1，初始化t1时认为已经是第二次加载类B3了，
    // 因此就算静态块没有初始化过，也认为初始化了，静态块不在执行
    // 只执行构造块和构造函数，t2同理
    // 在t1，t2初始化完成之后继续进行静态块，算是第一次加载类B执行静态块初始化，然后执行main()方法，新建对象，最后一次输出构造块。
    public static B3 t1 = new B3();
    public static B3 t2 = new B3();
    public static void main(String[] args)
    {
        B3 t = new B3();
    }
}
