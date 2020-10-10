package DataStructure.String;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/07/2019 15:00
 **/

public class SimplePatternMatching {

    public int patternMatching(String s,String t){
        char[] chars=s.toCharArray();
        char[] subchars=t.toCharArray();
        int sL=chars.length;
        int tL=subchars.length;
        // starting position
        int ss=0;
        int st=0;
        while(ss<sL&&st<tL){
            if(chars[ss]==subchars[st]){
                ++ss;
                ++st;
            }else{
                ss=ss-st+1;
                st=0;
            }
        }
        if(st>=tL)
            return ss-tL;
        else
            return -1;
    }

    public static void main(String[] args) {
        SimplePatternMatching ss=new SimplePatternMatching();
        String s="good google";
        String t="google";
        System.out.println(ss.patternMatching(s,t));
    }
}
