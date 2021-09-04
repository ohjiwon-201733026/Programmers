package Programmers.Lv3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 광고삽입 {
    public static void main(String [] args){
        String play_time="50:00:00";
        String adv_time="50:00:00";
        String [] logs={"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"
        };
        System.out.println(solution(play_time,adv_time,logs));
    }
    // 2-4 , 3~5
    // 0 1 2 3 4 5 6 7
    // 0 0 1 2 1 0 0 0
    public static String solution(String play_time,String adv_time,String [] logs){
        int playTime=strToSec(play_time);
        int advTime=strToSec(adv_time); // 2
        int [] count=new int [playTime+1]; // 영상 재생 시간 00:00:00 ~ playTime까지

        for(String log : logs){
            String [] splits=log.split("-");
            int startViewTime=strToSec(splits[0]);
            int endViewTime=strToSec(splits[1]);

            // 시청 시간 +1, endViewTime 포함하지 않음
            for(int i=startViewTime;i<endViewTime;++i){
                count[i]++;
            }
        }

        // 0초에 관고를 넣는다 가정했을 때 누적값 계산
        int startTime=0;
        int endTime=advTime;
        long sum=0;
        for(int i=startTime;i<endTime;++i){
            sum+=count[i];
        }

        // 누적값에서 앞에 값을 빼고 뒤에 값을 추가하면서 각초마다 광고를 넣었을 때의 누적값을 구하고 비교
        long max=sum;
        int maxStartTime=0;
        while(endTime<=playTime){
            sum-=count[startTime];
            sum+=count[endTime];
            if(sum>max){
                max=sum;
                maxStartTime=startTime+1;
            }
            startTime++;
            endTime++;
        }
        return secondToStr(maxStartTime);

    }
    public static String secondToStr(int time){
        int H=time/3600;
        int M=(time%3600)/60;
        int S=(time%3600)%60;

        return String.format("%02d:%02d:%02d",H,M,S);
    }
    public static int strToSec(String time){
        String [] t=time.split(":");
        return Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
    }
}
