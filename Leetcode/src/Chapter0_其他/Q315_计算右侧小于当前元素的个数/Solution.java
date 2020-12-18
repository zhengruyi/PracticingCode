package Chapter0_其他.Q315_计算右侧小于当前元素的个数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:52
 **/

public class Solution {
    public List <Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList <>();
        int len = nums.length;
        if(len == 0){
            return result;
        }
        //索引数组，整个过程比较时根据nums数组排序，但是真正调整的是索引数组
        int[] indexes =  new int[len];
        //归并排序需要借助的辅助数组
        int[] temp = new int[len];
        //存放最终结果的数组
        int[] res = new int[len];
        for(int i = 0; i< len;i++){
            indexes[i] = i;
        }
        mergerAndCounter(nums,0,len-1,indexes,temp,res);
        for(int i : res){
            result.add(i);
        }
        return result;
    }
    public void mergerAndCounter(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res){
        if(left == right){
            return;
        }
        int mid = left +(right - left)/2;
        mergerAndCounter(nums,left,mid,indexes,temp,res);
        mergerAndCounter(nums,mid+1,right,indexes,temp,res);
        if(nums[indexes[mid]] <= nums[indexes[mid+1]]){
            return;
        }
        mergerTwoSortedList(nums,left,mid,right,indexes,temp,res);
    }
    public void mergerTwoSortedList(int[] nums, int left,int mid, int right, int[] indexes, int[] temp, int[] res){
        for(int i = left; i<= right; i++){
            temp[i] = indexes[i];
        }
        int i = left;
        int j = mid+1;
        for(int k = left; k<= right; k++){
            if(i > mid){
                indexes[k] = temp[j];
                j++;
            }else if(j > right){
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (right - mid);
            }else if(nums[temp[i]] <= nums[temp[j]]){
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid -1);
            }else{
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}
