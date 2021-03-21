package Chapter0_其他.Q436_寻找右区间;

import java.util.TreeMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/03/2021 23:54
 **/

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        //利用treeMap自带的排序属性
        TreeMap <Integer,Integer> map = new TreeMap();
        for(int i = 0; i < intervals.length; i++){
            //按照其实时间排序好
            map.put(intervals[i][0],i);
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < res.length; i++){
            //找到下一个开头比当前结束早的键值,这里减去1,是因为下一个区间的开头如果等于当前区间的结尾
            //也是可以的
            Integer key = map.higherKey(intervals[i][1] - 1);
            if(key == null){
                res[i] = -1;
            }else{
                //获得对应的下标
                res[i] = map.get(key);
            }
        }
        return res;
    }
}
