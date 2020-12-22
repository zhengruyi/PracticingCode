package Chapter0_其他.Q186_翻转字符串的单词II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:20
 **/

public class Solution {
    public void reverseWords(char[] s) {
        //基本思路相同，向全部翻转在逐个单词翻转
        int len = s.length - 1;
        reverse(s,0,len);
        int start = 0;
        for(int i = 0; i < len; i++){
            if(s[i] == ' '){
                reverse(s,start, i-1);
                start = i+1;
            }
        }
        //终点这里要考虑最后的收尾，因为逻辑是遇到空格开始反转，所以要特意考虑最后一个单词的反转情况
        reverse(s,start,len);
    }
    public void reverse(char[] s,int start, int end){
        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
