package cn.edu.bjfu.swap;

/**
 * @author chaos
 * @date 2022-09-27 16:13
 */
class Animal {
    private String type;
    private String cry;

    public Animal(String type, String cry) {
        this.type = type;
        this.cry = cry;
    }

    public String getType() {
        return type;
    }
}

public class Transform {
    public static void transform(Animal a, Animal b) {
        Animal temp = a;
        a = b;
        b = temp;
    }

    public static void transform(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        Animal cat = new Animal("cat","miao");
        Animal dog = new Animal("dog","wang");
        transform(cat, dog);
        transform(a,b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(cat.getType());
        System.out.println(dog.getType());
    }
}