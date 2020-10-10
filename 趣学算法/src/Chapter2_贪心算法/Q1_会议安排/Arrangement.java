package Chapter2_贪心算法.Q1_会议安排;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/07/2020 15:56
 **/

public class Arrangement {
    public static void arrange(Meeting[] meets){
        Arrays.sort(meets, new Comparator <Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end){
                    return o2.start - o1.start;
                }
                return o1.end - o2.end;
            }
        });
        int num = 0;
        int endTime = 0;
        ArrayList<Meeting> arrayList = new ArrayList <Meeting>();
        for (int i = 0; i < meets.length; i++) {
            if(meets[i].start > endTime){
                endTime = meets[i].end;
                arrayList.add(meets[i]);
                num++;
            }
        }
        for(Meeting meet : arrayList) {
            System.out.println("meeting start at : " + meet.start + " end at : " + meet.end);
        }
    }

    public static void main(String[] args) {
        Meeting[] meets = new Meeting[10];
        meets[0] = new Meeting(3,6);
        meets[1] = new Meeting(1,4);
        meets[2] = new Meeting(5,7);
        meets[3] = new Meeting(2,5);
        meets[4] = new Meeting(5,9);
        meets[5] = new Meeting(3,8);
        meets[6] = new Meeting(8,11);
        meets[7] = new Meeting(6,10);
        meets[8] = new Meeting(8,12);
        meets[9] = new Meeting(12,14);
        arrange(meets);

    }
}
