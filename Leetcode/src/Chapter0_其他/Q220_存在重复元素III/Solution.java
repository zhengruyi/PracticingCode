package Chapter0_其他.Q220_存在重复元素III;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:21
 **/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map <Long,Long> map = new HashMap <>();
        //因为存在t = 0和t 很大的情况，所以采用 t + 1,以及转化成long
        //这里t就是一个桶中的元素数量
        long w = (long)t + 1;
        for(int i = 0; i < nums.length; i++){
            long m = getId(nums[i],w);
            //一个桶中的元素数量是t~2t-1总共有t个元素,那么i - j <= k 且两个元素的差值小于 t
            if(map.containsKey(m)){
                return true;
            }
            //检查相邻桶 m - 1 中的元素，是够满则绝对距离小于w
            if(map.containsKey(m-1) && Math.abs(nums[i] - map.get(m-1)) < w){
                return true;
            }
            //检查相邻桶 m + 1中的元素，它的绝对距离是否小于w
            if(map.containsKey(m + 1) && Math.abs(nums[i] - map.get(m+1)) < w){
                return true;
            }
            //跟新桶的元素
            map.put(m,(long)nums[i]);
            //如果当前索引差值大于k则删去对应桶中的元素
            if( i >= k){
                map.remove(getId(nums[i-k],w));
            }
        }
        return false;
    }
    public long getId(long x,long w){
        //这里要对负数做特殊处理 -3/5 = 0,我们希望等于-1，所以我们-1 ~ -5都归类于 -1
        //所以对于负数部分变成 (x+1)/w;
        return x < 0 ? (x + 1)/w - 1 : x/w;
    }
}
