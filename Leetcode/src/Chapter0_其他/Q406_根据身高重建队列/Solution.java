package Chapter0_其他.Q406_根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 17:57
 **/

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按照person[0]从小到大排序,如果两个元素的0位置数字相同
        //那么再按照person[1]数字降序排列
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o2[1] - o1[1];
            }
        });
        int n = people.length;
        //这里没有指定new int[n][]，那么每个元素像res[0],res[1]都是null
        //但如果指定了具体的数字，那么就是[0,0]
        int[][] res = new int[n][];
        for(int[] person : people){
            //计算要放置的位置
            int space = person[1] + 1;
            for(int i = 0; i < n; i++){
                if(res[i] == null){
                    --space;
                    //等于0是代表前面已经预留了足够的空间给后面的元素
                    if(space == 0){
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
