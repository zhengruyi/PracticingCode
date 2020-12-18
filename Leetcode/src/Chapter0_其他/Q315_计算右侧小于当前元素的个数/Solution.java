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
        //初始化索引数组
        for(int i = 0; i< len;i++){
            indexes[i] = i;
        }
        //进行归并排序来统计结果
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
        //计算分割点
        int mid = left +(right - left)/2;
        //归并排序左半部分
        mergerAndCounter(nums,left,mid,indexes,temp,res);
        //归并排序右半部分
        mergerAndCounter(nums,mid+1,right,indexes,temp,res);
        //优化，如果左半部分都小于右半部分，那么不需要合并，数组已经有序，也就不存在逆序
        if(nums[indexes[mid]] <= nums[indexes[mid+1]]){
            return;
        }
        //合并两个有序链表
        mergerTwoSortedList(nums,left,mid,right,indexes,temp,res);
    }
    public void mergerTwoSortedList(int[] nums, int left,int mid, int right, int[] indexes, int[] temp, int[] res){
        //因为indexes要存放排序后的结果
        for(int i = left; i<= right; i++){
            temp[i] = indexes[i];
        }
        //确定两个有序数组的起始点
        int i = left;
        int j = mid+1;
        for(int k = left; k<= right; k++){
            //左子数组已经存入完毕
            if(i > mid){
                indexes[k] = temp[j];
                j++;
                //右子数组都存入完毕
            }else if(j > right){
                indexes[k] = temp[i];
                i++;
                //此时对于每一个左子数组的元素来说，都比右子数组大，所以存在right-mid个元素，因为Mid是左子数组的最右一个元素
                //所以这里不用加1
                res[indexes[k]] += (right - mid);
            }else if(nums[temp[i]] <= nums[temp[j]]){
                //代表当前i小于对应的j，那么i一定大于mid+1..j-1之间的数字，所以可以加上j-mid-1
                indexes[k] = temp[i] ;
                i++;
                res[indexes[k]] += (j - mid -1);
            }else{
                //j小于对应的i,那么j往后退一步
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}
