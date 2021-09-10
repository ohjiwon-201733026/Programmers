package Programmers.Lv3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 광고삽입 {
    public static void main(String [] args){
        String play_time="02:03:55";
        String adv_time="00:14:15";
        String [] logs={"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
        };
        System.out.println(solution(play_time,adv_time,logs));
    }

    public static String solution(String play_time,String adv_time,String [] logs) {
        int playTime=stringToSec(play_time);
        int advTime=stringToSec(adv_time);
        int [] time=new int [playTime+1];
        for(String log:logs){
            String [] s=log.split("-");
            int startTime=stringToSec(s[0]);
            int endTime=stringToSec(s[1]);

            for(int i=startTime;i<endTime;++i){
                time[i]++;
            }
        }

        int startPlayTime=0;
        int endPlayTime=advTime;
        long sum=0;
        for(int i=startPlayTime;i<endPlayTime;++i){
            sum+=time[i];
        }

        long max=sum;
        int maxStartTime=0;
        while(endPlayTime<=playTime){
            sum-=time[startPlayTime];
            sum+=time[endPlayTime];
            if(sum>max){
                max=sum;
                maxStartTime=startPlayTime+1;
            }
            startPlayTime++;
            endPlayTime++;
        }
        return secondToString(maxStartTime);
    }

    private static String secondToString(int maxStartTime) {
        int H=maxStartTime/3600;
        int M=(maxStartTime%3600)/60;
        int S=((maxStartTime%3600)%60);
        return String.format("%02d:%02d:%02d",H,M,S);
    }

    public static int stringToSec(String play_time){
        String [] s=play_time.split(":");
        return Integer.parseInt(s[0])*3600 + Integer.parseInt(s[1])*60
                +Integer.parseInt(s[2]);
    }
}
