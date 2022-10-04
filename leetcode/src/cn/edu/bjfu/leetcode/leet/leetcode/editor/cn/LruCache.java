package cn.edu.bjfu.leetcode.leet.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Chaos
 * @date 2022-07-23 09:47:09
 */
public class LruCache {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class LRULinkedNode {
            int key;
            int val;
            LRULinkedNode pre;
            LRULinkedNode next;

            public LRULinkedNode() {
            }

            public LRULinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int size;
        private int capacity;
        private LRULinkedNode head, tail;
        private Map<Integer, LRULinkedNode> cache;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new LRULinkedNode();
            tail = new LRULinkedNode();
            head.next = tail;
            tail.pre = head;
            cache = new HashMap<>((int) (capacity * 1.5));
        }

        public int get(int key) {
            LRULinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            LRULinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                LRULinkedNode newNode = new LRULinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addFirst(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    LRULinkedNode tail = removeLast();
                    // 删除哈希表中对应的项
                    cache.remove(Objects.requireNonNull(tail).key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.val = value;
                moveToHead(node);
            }
        }

        private LRULinkedNode removeLast() {
            if (tail.pre == head) {
                return null;
            }
            LRULinkedNode res = tail.pre;
            remove(res);
            return res;
        }

        private void moveToHead(LRULinkedNode node) {
            remove(node);
            addFirst(node);
        }

        private void addFirst(LRULinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void remove(LRULinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}