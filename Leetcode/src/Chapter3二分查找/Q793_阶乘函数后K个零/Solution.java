package Chapter3二分查找.Q793_阶乘函数后K个零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/10/2020 14:39
 **/

public class Solution {
    public int preimageSizeFZF(int K) {
        long[] res = binarySearch(K);
        return (int)(res[1] - res[0] + 1);
    }
    public long[] binarySearch(int K){
        long[] res = new long[2];
        long right = Long.MAX_VALUE;
        long left = 0;
        //寻找左边界，由于right为指向范围外，所以终止条件是left == right,循环判断条件是lef < right没有等号
        while(left < right){
            long mid = left + (right - left)/2;
            long num = getNumberOfZeros(mid);
            if(num == K){
                //right 指向没有遍历的元素，所以这里right = mid 而不是 mid = right -1;
                right = mid;
            }else if(num < K){
                //left指向实体元素，所以是left = mid +1;
                left = mid + 1;
            }else if(num > K){
                //同样的的道理
                right = mid;
            }
        }
        //做边界是left指向的元素
        res[0] = left;
        right = Long.MAX_VALUE;
        left = 0;
        while(left < right){
            long mid = left + (right - left)/2;
            long num = getNumberOfZeros(mid);
            if(num == K){
                // 和left 有关的都是mid +1;
                left = mid + 1;
            }else if(num < K){
                left = mid + 1;
            }else if(num > K){
                right = mid;
            }
        }
        //求右侧边界，因为right真正指向的有意义元素是right -1;
        res[1] = right -1;
        return res;
    }
    public long getNumberOfZeros(long num){
        long index = 5;
        long res = 0;
        while(index <= num){
            res+= num/index;
            index = index * 5;
        }
        return res;
    }
}
