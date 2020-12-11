package Chapter0_其他.Q179_最大数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/12/2020 23:08
 **/

public class Solution {
    String[] strs;

    /**
     * 总的来说吧数组中的数字排列成最大数或者最小数，本质上就是用改变了快排的方法
     * 具体来说只改变了比较函数，其余不变
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        strs = new String[nums.length];
        //只有封装后的Integer.String等实现了comparable接口，可以用来比较大小
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(0,strs.length - 1);
        StringBuilder builder = new StringBuilder();
        //去除前缀0
        boolean isFirstZero = true;
        for(int i =0; i < strs.length; i++){
            if(isFirstZero && strs[i].equals("0")){
                continue;
            }
            isFirstZero = false;
            builder.append(strs[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();

    }
    public void quickSort(int start, int end){
        if(start >= end){
            return;
        }
        //填坑法实现快速排序
        int left = start;
        int right = end;
        String threshold = strs[left];
        while(left < right){
            while(compare(strs[right],threshold) && left < right){
                right--;
            }
            if(left < right){
                strs[left] = strs[right];
                left++;
            }
            while(!compare(strs[left],threshold) && left < right){
                left++;
            }
            if(left < right){
                strs[right] = strs[left];
                right--;
            }
        }
        strs[left] = threshold;
        quickSort(start,left);
        quickSort(left+1, end);
    }
    /**
     * 由于这里是构成最大数，所以是快排降序排列，所以对于compare(strs[right,threshold])来说
     * 希望right+threshold > threshold + right,所以对于所有right < threshold的右边元素来说，我们保持不变
     * 直到找到一个大于threshold的元素，填到左边去使整体更大
     */
    public boolean compare(String s1, String s2){
        return (s1+s2).compareTo(s2+s1) <= 0;
    }
}
