package Chapter0_其他.Q667_优美的排列II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/03/2021 21:25
 **/

public class Solution {
    /**
     * 初始状态所有间隔都是1，然后翻转一次,那么间隔变成1和n-1
     * 后续后退一个位置，再进行一次翻转,间隔就会多一个n - 2
     * 总的来说:
     * 想要只要一个不同的间隔,那么就直接返回
     * 想要m个间隔,那么需要迭代m次,每次后退一个位置,然后将剩余的数组全部翻转过来
     * 这样就可增加一个不同的间隔
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i = 1; i <= n; i++){
            res[i-1] = i;
        }
        if(k == 1){
            return res;
        }
        for(int i = 2; i <= k; i++){
            reverse(res,i-1,res.length - 1);
        }
        return res;
    }
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
