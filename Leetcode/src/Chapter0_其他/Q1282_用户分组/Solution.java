package Chapter0_其他.Q1282_用户分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:52
 **/

public class Solution {
    public List<List <Integer>> groupThePeople(int[] groupSizes) {
        Map <Integer,List<Integer>> map = new HashMap <>();
        //把用户所属于组的成员数目相同的节点放入到头那个一个链表中
        for(int i = 0; i < groupSizes.length; i++){
            if(map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else{
                List<Integer> t = new ArrayList <>();
                t.add(i);
                map.put(groupSizes[i],t);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        //将大小相同的用户组中的用户按照大小进行分来，安排到同一组中
        for(int size : map.keySet()){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> list = map.get(size);
            for(int i = 0; i < list.size(); i++){
                tmp.add(list.get(i));
                if(tmp.size() == size){
                    res.add(tmp);
                    tmp = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
