package Chapter0_其他.Q0_KMP算法;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/11/2020 11:31
 **/

public class Solution {
    static int[] next = new int[1000];
    static char[] chas;
    static char[] chap;
    public static void search(String s, String p){
        buildNext(s,p);
        int tar = 0, pos = 0;
        while(tar < chas.length){
            if(chas[tar] == chap[pos]){
                pos++;
                tar++;
            }else if(pos != 0){
                pos = next[pos-1];
            }else{
                tar++;
            }
            if(pos == chap.length){
                System.out.println("index = "+ (tar - pos));
                return;
            }
        }
        System.out.println("not found");

    }
    public static void buildNext(String s, String p){
        chas = s.toCharArray();
        chap = p.toCharArray();
        int i = 1;
        int now = 0;
        while(i < chap.length){
            if(chap[i] == chap[now]){
                now++;
                next[i] = now;
                i++;
            }else if(now != 0){
                now = next[now-1];
            }else{
                i++;
                next[i] = now;
            }
        }
    }

    public static void main(String[] args) {
        search("abasxxsgaxgs","ax");
    }
}
