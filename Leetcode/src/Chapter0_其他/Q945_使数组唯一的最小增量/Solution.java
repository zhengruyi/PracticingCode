package Chapter0_其他.Q945_使数组唯一的最小增量;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/01/2021 21:47
 **/

public class Solution {
    /**
     * 这里的主要思想就是见缝插针,每次遇到不连续的数字就需要把前面相等的数字数目进行计算
     * 并且减少相同的数字数目
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        if(A.length <= 1){
            return 0;
        }
        int ans = 0;
        int count = 0;
        //对所有数字进行排序
        Arrays.sort(A);
        for(int i = 1; i < A.length; i++){
            //统计相同的数字数目,并且减去基础数字A[i-1]，因为如果是纯递增序列(ex:1,2,3)的话
            //那么可能后续需要在别的数字基础上计算提升量
            if(A[i] == A[i-1]){
                count++;
                ans -= A[i-1];
            }else{
                //这里计算两个不同数字之间的差值,可以塞进去多少个数字
                //这里give去差值和前面相同数字的最小值,由于区间是[A[i-1]+1,A[i] - 1]
                //所以数字总数是A[i] - A[i-1] - 1
                int give = Math.min(count,A[i] - A[i-1] - 1);
                //基础是A[i-1]然后地增量是1..give，所以总数是give * A[i-1] + give* (give + 1)/2
                ans += give * A[i-1] + give * (give + 1)/2;
                count -= give;
            }
        }
        if(count > 0){
            //如果到末尾还有count，那么就需要在A[A.length-1]基础上添加变量来
            //使数组中的数字唯一
            ans += count * (count + 1)/2 + count * A[A.length-1];
        }
        return ans;
    }
}
