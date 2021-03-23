package Chapter0_其他.Q1802_有界数组中指定下标处的最大值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/03/2021 23:31
 **/

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        if(maxSum < n){
            return 0;
        }
        //表示从Index往外扩的范围
        int dl = 0, dr = 0;
        int diff = maxSum - n;
        int left = index, right = index;
        //起始高度为1，因为起始每层至少高度为1，在此基础上
        //再将剩余的砖块放在位置上
        int res = 1;
        while(diff > 0){
            //往左扩一步
            if(--left >= 0){
                dl++;
            }
            //往右扩一步
            if(++right < n){
                dr++;
            }
            //如果已经到达了边界,那么相对的高度差已经确定了,剩下的就是整体增长
            //但如果有砖头剩余,那么Index可以在再次增加1
            if(left <0 && right >= n){
                res += Math.ceil(diff * 1.0 / n);
                break;
            }else{
                //减去本次增高需要的砖头量
                diff -= (dl + dr + 1);
            }
            //index处高度加1
            res++;
        }
        return res;
    }
}
