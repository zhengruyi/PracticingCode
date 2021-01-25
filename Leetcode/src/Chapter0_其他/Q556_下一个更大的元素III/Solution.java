package Chapter0_其他.Q556_下一个更大的元素III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/01/2021 23:00
 **/

public class Solution {
    public int nextGreaterElement(int n) {
        char[] chas = String.valueOf(n).toCharArray();
        int i = chas.length - 2;
        //从右往左找到第一个chas[i] > chas[i+1]
        while(i >= 0 && chas[i] >= chas[i+1]){
            i--;
        }
        //如果原来的数字序列就是降序排列，那么不存在更大的序列返回-1
        if( i < 0){
            return -1;
        }
        //此时说明从i..末尾都是降序序列,此时在从右往左搜索,找到第一个比chas[i]大的元素
        int j = chas.length - 1;
        while(chas[j] <= chas[i]){
            j--;
        }
        //交换后，i+1..末尾任然降序排列，所以把末尾改成升序排列后就是下一个较大的数字
        swap(chas,i,j);
        reverse(chas,i+1,chas.length - 1);
        long res = Long.parseLong(new String(chas));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    public void swap(char[] chas, int i, int j){
        char c = chas[i];
        chas[i] = chas[j];
        chas[j] = c;
    }
    public void reverse(char[] chas, int i, int j){
        while(i <= j){
            swap(chas,i,j);
            i++;
            j--;
        }
    }
}
