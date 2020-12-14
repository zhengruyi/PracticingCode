package Chapter0_其他.Q605_种花问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/12/2020 22:42
 **/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if( n == 0){
            return true;
        }
        int len = flowerbed.length;
        for(int i = 0; i < len; i++){
            //这里采用复杂的条件判断，首先相邻的节点的值是否为1,还要考虑最左和最右两种情况
            if((i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= len || flowerbed[i + 1] == 0) && flowerbed[i] == 0){
                flowerbed[i] = 1;
                n--;
            }
            //花全部可以种下，所以返回true
            if(n == 0){
                return true;
            }
        }
        return false;
    }
}
