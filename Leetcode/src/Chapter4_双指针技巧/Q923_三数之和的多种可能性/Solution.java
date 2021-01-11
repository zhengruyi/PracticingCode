package Chapter4_双指针技巧.Q923_三数之和的多种可能性;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/01/2021 22:10
 **/

public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_000 + 7;
        //这里用long的原因不是因为统计次数超过int，因为后面可能会乘法计算时超出int的上界
        long[] count = new long[101];
        int uniq = 0;
        //统计每个数字的出现频率
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
            if(count[arr[i]] == 1){
                uniq++;
            }
        }
        //统计数字的出现种类
        int[] keys = new int[uniq];
        int index = 0;
        //给keys数组赋值
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                keys[index++] = i;
            }
        }
        long ans = 0;
        for(int i = 0; i < keys.length; i++){
            //选定i后，计算j和k两个数字的数字之和
            int T = target - keys[i];
            //双指针法遍历来计算所有的可能性
            int j = i;
            int k = keys.length - 1;
            while(j <= k){
                if(keys[j] + keys[k] < T){
                    j++;
                }else if(keys[j] + keys[k] > T){
                    k--;
                }else{
                    //依据i，j,k是全部不同还是部分相同来计算所有可能的种类数目
                    if(i < j && j < k){
                        ans += count[keys[i]] * count[keys[j]] * count[keys[k]];
                    }else if( i < j && j == k){
                        ans += count[keys[i]] * count[keys[j]] * (count[keys[j]] - 1) /2;
                    }else if(i == j && j < k){
                        ans += count[keys[k]] * count[keys[i]] * (count[keys[i]] - 1) /2;
                    }else{
                        ans += count[keys[i]] * (count[keys[i]] - 1) * (count[keys[i]] - 2) / 6;
                    }
                    ans %= mod;
                    j++;
                    k--;
                }

            }
        }
        return (int) ans;
    }
}
