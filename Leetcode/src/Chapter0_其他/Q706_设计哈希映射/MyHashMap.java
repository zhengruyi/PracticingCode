package Chapter0_其他.Q706_设计哈希映射;

import java.util.LinkedList;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:33
 **/

public class MyHashMap {
    LinkedList <Entry>[] list;
    //len越长则哈希冲突的越小，需要遍历的链表越短，越快
    int len = 2069;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new LinkedList[len];
        for(int i = 0; i < list.length; i++){
            list[i] = new LinkedList<Entry>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % len;
        LinkedList<Entry> tmp = list[index];
        for(int i = 0; i < tmp.size(); i++){
            if(tmp.get(i).key == key){
                tmp.get(i).value = value;
                return;
            }
        }
        tmp.add(new Entry(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % len;
        LinkedList<Entry> tmp = list[index];
        for(int i = 0; i < tmp.size(); i++){
            if(tmp.get(i).key == key){
                return tmp.get(i).value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % len;
        LinkedList<Entry> tmp = list[index];
        for(int i = 0; i < tmp.size(); i++){
            if(tmp.get(i).key == key){
                tmp.remove(i);
            }
        }
    }
}
class Entry{
    public int key;
    public int value;
    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
}