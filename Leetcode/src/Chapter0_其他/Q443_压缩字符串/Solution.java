package Chapter0_其他.Q443_压缩字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/01/2021 19:44
 **/

public class Solution {
    public int compress(char[] chars) {
        //表示起始点的字符
        int anchor = 0;
        //写入字符的位置
        int write = 0;
        for(int read = 0; read < chars.length; read++){
            //当read到达数组末尾或者下一个字符和当前字符不相等时启动
            if(read +1 == chars.length || chars[read] != chars[read+1]){
                //将起始字符加入
                chars[write++] = chars[anchor];
                //表示字符的出现次数大于1那么压缩后的字符串长度小于等于压缩前
                if(read > anchor){
                    //把数字循环换成字符串压入
                    for(char c : ("" + (read - anchor + 1)).toCharArray()){
                        chars[write++] = c;
                    }
                }
                //返回更新后的起始点
                anchor = read+1;
            }

        }
        return write;
    }
}
