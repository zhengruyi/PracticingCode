package Chapter0_其他.Q484_寻找排列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/02/2021 21:16
 **/

public class Solution {
    /**
     * 先将所有的数字按从小到大的顺序放入数组中,然后搜索字符串将所有d..l的序列反向翻转一下
     * 因为所有的l序列本身就满足递增的条件,所以只要将d..l之间的序列翻转就可以满足条件
     * @param s
     * @return
     */
    public int[] findPermutation(String s) {
        int len = s.length();
        int[] res = new int[len + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = i + 1;
        }
        int index = 0;
        int lastD = 0;
        while(index < len){
            lastD = index;
            while(index < len && s.charAt(index) == 'D'){
                index++;
            }
            reverse(res,lastD,index);
            index++;
        }
        return res;
    }
    public void reverse(int[] res, int start, int end){
        while(start < end){
            int tmp = res[start];
            res[start] = res[end];
            res[end] = tmp;
            start++;
            end--;
        }
    }
}
