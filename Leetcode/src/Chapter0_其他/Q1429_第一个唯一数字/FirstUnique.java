package Chapter0_其他.Q1429_第一个唯一数字;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:15
 **/

public class FirstUnique {
    LinkedHashSet <Integer> set = new LinkedHashSet<>();
    Set <Integer> deleted = new HashSet <>();
    public FirstUnique(int[] nums) {
        for(int i : nums){
            traite(i);
        }
    }

    public int showFirstUnique() {
        //如果LinkedHashSet时空的那就返回-1,LinkedHashSet的特定是迭代的顺序就是存入的顺序
        return set.isEmpty() ? -1 : set.iterator().next();
    }

    public void add(int value) {
        traite(value);
    }
    public void traite(int v){
        //如果这个元素时已经被删除了，那么直接返回，因为只要出现两次以上就无效
        if(deleted.contains(v)){
            return;
        }
        //如果set已包含，那么就把这个元素删除放入delete这个集合中
        if(set.contains(v)){
            set.remove(v);
            deleted.add(v);
        }else{
            set.add(v);
        }
    }
}

