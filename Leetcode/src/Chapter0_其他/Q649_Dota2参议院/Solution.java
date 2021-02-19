package Chapter0_其他.Q649_Dota2参议院;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/02/2021 23:19
 **/

public class Solution {
    public String predictPartyVictory(String senate) {
        //Rnumber,Dnumber分别表示当前被ban的R和D的总人数
        int Rnumber = 0;
        int Dnumber = 0;
        //要被ban的R和D的人数
        int banR = 0;
        int banD = 0;
        //统计总共R和D的总人数
        int totalR = 0;
        int totalD = 0;
        int total = senate.length();
        //表示遍历完一边没有，用来确定总人数
        boolean flag = true;
        char[] chas = senate.toCharArray();
        while(true){
            for(int i = 0; i < chas.length; i++){
                //如果当前是'R'
                if(chas[i] == 'R'){
                    //R总人数加1
                    if(flag){
                        totalR++;
                    }
                    //当前R不会被ban,那么下一个D会被ban
                    if(banR == 0){
                        //统计要被ban的D和被ban的D的总人数
                        banD++;
                        Dnumber++;
                        //如果D的总人数已经确定且都会被ban那么就直接宣布获胜方
                        if(Dnumber == totalD && !flag){
                            return "Radiant";
                        }
                    }else{
                        //当前R被ban，那么后续要被ban的人数减去1
                        chas[i] = 'r';
                        banR--;
                    }
                }else if (chas[i] == 'D'){
                    if(flag){
                        totalD++;
                    }
                    if(banD == 0){
                        banR++;
                        Rnumber++;
                        if(Rnumber == totalR && !flag){
                            return "Dire";
                        }
                    }else{
                        chas[i] = 'd';
                        banD--;
                    }
                }
            }
            //遍历完一遍，那么总的人数已经确定,任何一方被ban的人数超过总人数那么另外一方自动获胜
            flag = false;
            if(Rnumber >= totalR){return "Dire";}
            if(Dnumber >= totalD){return "Radiant";}
        }
    }
}
