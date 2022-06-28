package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaos
 * @date 2022-06-28 10:48:42
 */
public class MinStack1 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Deque<Long> stack;
        long min;

        public MinStack() {
            stack = new LinkedList<Long>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
                stack.push(0L);
                return;
            }
            stack.push((long) val - min);
            min = Math.min(val, min);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            long x = stack.pop();
            if (x >= 0) {
                return;
            }
            min = min - x;
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            if (stack.peek() <= 0) {
                return (int) min;
            }
            return (int) (min + stack.peek());
        }

        public int getMin() {
            return (int) min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}