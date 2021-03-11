package Chapter0_其他.Q781_森林里的兔子;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/03/2021 23:09
 **/

public class Solution {
    public int numRabbits(int[] answers) {
        if(answers.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        //统计森林里报一份数字的兔子数目
        for(int num : answers){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int res = 0;
        for(int key : map.keySet()){
            int times = map.get(key);
            //报有k个兔子和自己相同颜色的兔子种群数量至少是k+1
            //计算种群数量取上限,大小为 (times + key) / (key + 1)
            res += ((times + key) / (key + 1)) * (key + 1);

        }
        return res;
    }
}
