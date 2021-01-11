package Chapter14_深度搜索和广度搜索.Q306_累加数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/01/2021 21:56
 **/

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() <= 2){
            return false;
        }
        return dfs(num,num.length(),0,0,0,0);
    }

    /**
     * 采用深度遍历来遍历所有可能性
     * @param number
     * @param length
     * @param index 当前检索位置
     * @param sum 前两个数字的和
     * @param pre 前一个数字
     * @param k 当前是第几个数字
     * @return
     */
    public boolean dfs(String number, int length, int index,long sum, long pre, int k){
        //到达末尾,如果累计遍历过得数字大于2，那么分割有效
        if(index == length){
            return k > 2;
        }
        for(int i = index; i < length; i++){
            long curr = getNumber(number,index,i);
            //数字无效剪枝
            if(curr < 0){
                continue;
            }
            //当前数字是第3及以后，所以要验证是否等于前两个数字的和
            if(k >= 2 && curr != sum){
                continue;
            }
            //往后进行遍历查看后面是否也符合要求
            if(dfs(number,length,i+1,pre + curr, curr,k+1)){
                return true;
            }
        }
        return false;
    }

    /**
     * 将从left..right的字符串转化成数字，如果left < right且是已0开头，那么数字无效返回-1
     * @param number
     * @param left
     * @param right
     * @return
     */
    public long getNumber(String number, int left, int right){
        if(left < right && number.charAt(left) == '0'){
            return -1;
        }
        long res = 0;
        for(int i = left; i <= right; i++){
            res = res * 10 + number.charAt(i) - '0';
        }
        return res;
    }
}
