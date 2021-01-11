package Chapter0_其他.Q1702_修改后的最大二进制字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/01/2021 21:26
 **/

public class Solution {
    /**
     * 由于 00 -> 10 -> 01，所以可以将所有不紧靠右边的1变成从10 -> 01全部移动最左边
     * 那么最后剩下的二进制字符串的只会有一个0且靠近最右边的一个1,所以题目变成找出
     * 左边的连续1数目和右边的连续1数目,0会紧靠在右边的连续1。最终的结果时非左边连续的1
     * 会全部移动到最右边，除了左边连续的1，其余会变成10形式移动到最左边
     * @param binary
     * @return
     */
    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        //左边的连续1
        int left = 0;
        //右边的连续1
        int right = 0;
        //表示当前的1是否是左边连续的
        boolean flag = true;
        for(char c : chars){
            flag = (flag && c == '1');
            left += (flag && c == '1') ? 1 : 0;
            //统计右边的的1的个数
            right += (!flag && c == '1') ? 1 : 0;
        }
        int length = binary.length();
        //判断是否是全1的情况
        if(length > left + right){
            //计算最终0所在的位置
            int k = length - 1 - right;
            for(int i = 0; i < chars.length; i++){
                chars[i] =  i == k ? '0' : '1';
            }
        }
        return new String(chars);
    }
}
