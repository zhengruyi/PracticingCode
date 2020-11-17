package Chapter0_其他.Q264_丑数II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/11/2020 22:41
 **/

public class Solution {
    public int nthUglyNumber(int n) {
        // i2,i3,i5分别是智子昂三个元素的指针
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        //计算第几个丑数
        int times = 1;
        int index = 0;
        //保存所偶遇丑数的数组，因为丑数*2/3/5仍然是丑数，所以后续丑数是更具三个指针所指向的丑数然后分别*2,*3,*5
        //取其中最小的一个，就是当前的丑数
        int[] nums = new int[1690];
        nums[0] = 1;
        while(times < n){
            //计算所有指针指向丑数中计算后最小的丑数
            int ugly = Math.min(nums[i2] *2, Math.min(nums[i3] * 3, nums[i5] *5));
            nums[++index] = ugly;
            //将对应指针后移，这里切记不能用if...elseif..else因为一个丑数可能对应多个指针
            //比如丑数6对应 丑数3*2和丑数2*3,即可能出现一个丑数可能导致多个指针移动的情况
            if(ugly == nums[i2] *2){
                i2++;
            }
            if(ugly == nums[i3] * 3){
                i3++;
            }
            if(ugly == nums[i5] * 5){
                i5++;
            }
            times++;
        }
        return nums[index];
    }
}
