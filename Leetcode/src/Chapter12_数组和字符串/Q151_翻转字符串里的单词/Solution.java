package Chapter12_数组和字符串.Q151_翻转字符串里的单词;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/11/2020 23:42
 **/

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0){
            return s;
        }
        //将字符串全部反向
        s = new StringBuilder(s).reverse().toString();
        StringBuilder builder = new StringBuilder();
        int start = -1;
        int i;
        for(i = 0; i <s.length();i++){
            if(s.charAt(i) == ' '){
                //如果不满足条件，说明是两个空格靠在一起，则不需要计算
                if(i - start > 1){
                    //start指向的上一个空格位置，所以这里要用start+1..i来表示空格中间的内容
                    builder.append(new StringBuilder(s.substring(start+1,i)).reverse().toString());
                    builder.append(' ');
                }
                start = i;
            }
        }
        //由于上面的for循环不会处理最后一个非空字符，所以这里要做额外处理
        if(i - start > 1){
            builder.append(new StringBuilder(s.substring(start+1,i)).reverse().toString());
        }

        return builder.toString().trim();
    }
}
