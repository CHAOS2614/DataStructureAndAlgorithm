package cn.edu.bjfu.map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chaos
 * @date 2021-12-05 22:02
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        String put = map.put("name", "chaos");
        map.remove("name");
        System.out.println(put);
        String put1 = map.put("name", "chao");
        System.out.println(put1);
    }

    @Test
    public void fourMap() {
        HashMap<String, String> hashMap = new HashMap<>(16);
        Map<String, String> map = Collections.synchronizedMap(hashMap);
        map.put("age", "13");
        Hashtable<String, String> hashtable = new Hashtable<>();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("name", "chaos");
        System.out.println(Integer.numberOfLeadingZeros(16));
    }

}
