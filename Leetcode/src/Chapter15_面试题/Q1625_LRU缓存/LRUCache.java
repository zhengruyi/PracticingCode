package Chapter15_面试题.Q1625_LRU缓存;

import java.util.LinkedHashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 20:49
 **/

class LRUCache {
    /**
     *采用这种哈希表来保存，因为遍历顺序就是插入顺序
     */
    LinkedHashMap <Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //存在就跟新一下位置,来表示最近刚刚被访问过
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //更新时也要考虑输入顺序问题，跟新元素的顺序
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return;
        }
        if(map.size() < capacity){
            map.put(key,value);
        }else{
            //移除最旧的一个数据
            map.remove(map.keySet().iterator().next());
            map.put(key,value);
        }
    }
}
