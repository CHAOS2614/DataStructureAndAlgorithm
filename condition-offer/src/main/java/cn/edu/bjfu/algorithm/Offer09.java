package cn.edu.bjfu.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author chaos
 * @date 2021-12-11 11:03
 */
public class Offer09 {
}

class SimulationQueue {

    Deque<Integer> append;
    Deque<Integer> delete;

    public SimulationQueue() {
        append = new ArrayDeque<>();
        delete = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        append.offerLast(value);
    }

    public int deleteHead() {
        if (!delete.isEmpty()) {
            return delete.pollLast();
        } else {
            while (!append.isEmpty()) {
                delete.offerLast(append.pollLast());
            }
            return delete.isEmpty() ? -1 : delete.pollLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(Character.MIN_HIGH_SURROGATE);
        String s = new String();
        s.toLowerCase();
    }


}
