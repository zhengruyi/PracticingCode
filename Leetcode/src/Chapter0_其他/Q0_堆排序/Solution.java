package Chapter0_其他.Q0_堆排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 20:45
 **/

public class Solution {
    public void heapSort(int[] nums){
        //nums.length - 1是最后一个元素的下标,再减去1除以2是求父节点的坐标
        int start = ((nums.length - 1) - 1)/2;
        //从这个父节点开始调整堆
        for(int i = start; i >= 0; i--){
            heapify(nums,nums.length,i);
        }
        //每次让堆头和堆尾调换元素,然后重新调整堆,最后得到的数组就是升序数组
        for(int i = nums.length - 1; i > 0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums,i,0);
        }

    }

    public void heapify(int[] nums,int heapSize,int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        //找到当前节点和左右子节点中较大的值
        int larger = index;
        //比较当前节点和左子节点的较大值
        if(left < heapSize && nums[index] < nums[left]){
            larger = left;
        }
        //查看和右子树相比，那个值较大
        if(right < heapSize && nums[larger] < nums[right]){
            larger = right;
        }
        //递归调整堆
        if(larger != index){
            int temp = nums[index];
            nums[index] = nums[larger];
            nums[larger] = temp;
            heapify(nums,heapSize,larger);
        }

    }
}
