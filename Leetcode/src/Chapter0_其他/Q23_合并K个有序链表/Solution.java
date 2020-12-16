package Chapter0_其他.Q23_合并K个有序链表;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/12/2020 22:22
 **/

public class Solution {
    ListNode root = new ListNode(-1);
    ListNode head = root;
    public ListNode mergeKLists(ListNode[] lists) {
        //TreeMap 默认会按照键值从小到大来排序
        TreeMap <Integer, List <Integer>> map = new TreeMap<>();
        for(int i = 0; i < lists.length; i++){
            //将不同链表的第一个元素按照值和索引的形式存入哈希表中
            if(lists[i] != null){
                List<Integer> tmp = map.getOrDefault(lists[i].val, new ArrayList <>());
                tmp.add(i);
                map.put(lists[i].val, tmp);
                lists[i] = lists[i].next;
            }
        }
        while(map.size() != 0){
            //取出值最小的一个
            int key = map.firstKey();
            //获取所有以这个值开头的索引
            List<Integer> list = map.remove(key);
            //将值合并到结果链表中
            for(int index : list){
                head.next = new ListNode(key);
                head = head.next;
                //取出对应索引的链表的下一个值，存入hash表中
                if(lists[index] != null){
                    List<Integer> t = map.getOrDefault(lists[index].val,new ArrayList());
                    t.add(index);
                    map.put(lists[index].val,t);
                    lists[index] = lists[index].next;
                }
            }
        }
        return root.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
