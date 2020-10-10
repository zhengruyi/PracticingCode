package DataStructure.String;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/07/2019 15:31
 **/

public class KMP {
    public int patternMatching(String s,String t){
       int st=0;
       int ss=0;
       char[] chars=s.toCharArray();
       char[] subchars=t.toCharArray();
       int sL=s.length();
       int tL=t.length();
       int[] next=getNext(t);
       while(ss<sL && st<tL){
           if(st==-1||chars[ss]==subchars[st]){
               ++ss;
               ++st;

           }else{
               st=next[st];
           }
       } 
       if(st>=tL)
           return ss-tL;
       else
           return -1;
    }

    private int[] getNext(String s){
        char[] chars=s.toCharArray();
        int[]next=new int[s.length()];
        int sL=s.length();
        int index=0;
        int ss=-1;
        next[0]=-1;
        while(index<sL-1){
            if(ss==-1||chars[index]==chars[ss]){
                ++index;
                ++ss;
                next[index]=ss;
            }else
                ss=next[ss];
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp=new KMP();
        String s="gcsdhscghcdababaaaba";
        String t="ababaaaba";
        System.out.println(kmp.patternMatching(s,t));
    }
}
