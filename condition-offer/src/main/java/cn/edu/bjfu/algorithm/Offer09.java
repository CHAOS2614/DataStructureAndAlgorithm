package cn.edu.bjfu.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chaos
 * @date 2021-12-11 11:03
 */
public class Offer09 {
}

class CQueue {

    Deque<Integer> append;
    Deque<Integer> delete;

    public CQueue() {
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


}
