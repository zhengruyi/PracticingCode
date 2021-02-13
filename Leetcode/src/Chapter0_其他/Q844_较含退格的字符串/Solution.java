package Chapter0_其他.Q844_较含退格的字符串;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/02/2021 17:50
 **/

public class Solution {
    /**
     * 本质就是将字符串存入builder中如果存在#,那么就删除上一个字符,最后比较两个字符串是否相等
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#' ){
                if(builder.length() > 0){
                    builder.deleteCharAt(builder.length() - 1);
                }
            }else{
                builder.append(S.charAt(i));
            }
        }
        String s1 = builder.toString();
        builder.delete(0,builder.length());
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) == '#'){
                if(builder.length() > 0){
                    builder.deleteCharAt(builder.length() - 1);
                }
            }else{
                builder.append(T.charAt(i));
            }
        }
        return builder.toString().equals(s1);
    }
}
