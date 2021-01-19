package Chapter5_滑动窗口算法.Q904_水果成篮;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 22:48
 **/

public class Solution {
    /**
     * 本题主要的要点是用哈希表来统计区间的字符的种类和出现次数
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        for(right = 0; right < tree.length; right++){
            //跟新区间里面的字符种类和数目
            map.put(tree[right],map.getOrDefault(tree[right],0) + 1);
            //说明区间里面的数字种类大于2，所以需要收缩左边界
            if(map.size() > 2){
                //收缩左边界
                map.put(tree[left],map.get(tree[left]) - 1);
                //如果数目为0那么就删除这个字符
                if(map.get(tree[left]) == 0){
                    map.remove(tree[left]);
                }
                left++;
            }
            //更新最大的区间长度
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}
