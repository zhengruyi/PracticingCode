package Chapter3二分查找.Q1011_在D天内送达包裹的能力;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/10/2020 17:11
 **/

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 1;
        //上限是全部重量和+1
        int right = getSum(weights)+1;
        while(left < right){
            int mid = left +(right - left)/2;
            if(canFinish(weights, D, mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    /**
     * 判断能不能在有限天数内全部运往
     * */
    boolean canFinish(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getSum(int[] weights){
        int sum = 0;
        for(int i : weights){
            sum+=i;
        }
        return sum;
    }
}
