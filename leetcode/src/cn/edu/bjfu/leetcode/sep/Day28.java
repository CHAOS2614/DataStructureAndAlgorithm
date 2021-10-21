package cn.edu.bjfu.leetcode.sep;
import java.util.List;

/**
 * @author chaos
 * @date 2021-09-28 15:30
 */
public class Day28 {


    public static void main(String[] args) {
        BB bb = new BB();
    }

    public static void addStrings(List<? super A> list){
    }
}

class AA{
    static {
        System.out.println("AA静态代码块");
    }
    {
        System.out.println("AA普通代码块");
    }
    AA(String name){
        System.out.println("AA构造器");
    }
    
}
class BB extends AA{
    static {
        System.out.println("BB静态代码块");
    }
    {
        System.out.println("BB普通代码块");
    }
    BB(){
        super("name");
        System.out.println("BB构造器");
    }
}

