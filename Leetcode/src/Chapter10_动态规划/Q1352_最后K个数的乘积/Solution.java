package Chapter10_动态规划.Q1352_最后K个数的乘积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/11/2020 21:49
 **/

public class Solution {
    class ProductOfNumbers {
        int end;
        int size;
        int[] nums;
        //创建最大的数组来处理前缀积的结果
        public ProductOfNumbers() {
            nums = new int[40010];
            nums[0] =1;
            size = 1;
        }

        public void add(int num) {
            //当遇到0，时清零将下一个元素放在i = 1的位置上
            if(num == 0){
                size = 1;
            }else{
                //num != 0,那么就按照正常的逻辑计算前缀积
                nums[size] = num * nums[size-1];
                size++;
            }

        }

        public int getProduct(int k) {
            //由于每次size等于数组长度+1,所以当数组长度小于k表示中间存在0，所以最后乘积必定是0,可以直接返回
            if( size - 1 < k){
                return 0;
            }
            //利用前缀积数组快速返回区间积
            return nums[size -1]/ nums[size - k -1];
        }
    }
}
