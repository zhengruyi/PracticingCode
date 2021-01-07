package Chapter0_其他.Q705_设计哈希集合;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/01/2021 22:18
 **/

public class MyHashSet {
    Map <Integer, Integer> map;

    /**
     * Initialize your data structure here.
     * 在Java中HashSet底层就是一个不设值的hashmap
     */
    public MyHashSet() {
        map = new HashMap <>();
    }

    public void add(int key) {
        map.put(key, -1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return map.containsKey(key);
    }

}
