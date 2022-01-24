package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 광고삽입 {

    @Test
    public void test(){
        Assertions.assertEquals("01:30:59",solution("02:03:55","00:14:15",new String []{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    }

    public String solution(String play_time,String adv_time, String [] logs){
        int playTime=strToTime(play_time);
        int advTime=strToTime(adv_time);
        int [] count=new int [playTime+1];// 00:00:00 ~ playTime

        for(String log : logs) {
            String[] splits = log.split("-");
            int startViewTime = strToTime(splits[0]);
            int endViewTime = strToTime(splits[1]);

            for (int i = startViewTime; i < endViewTime; ++i) count[i]++;
        }


            int startTime=0;
            int endTime=advTime;
            long sum=0;
            for(int i=startTime;i<endTime;++i) sum+=count[i];

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

    public int strToTime(String time){
        String [] spl=time.split(":");
        return Integer.parseInt(spl[0])*3600+Integer.parseInt(spl[1])*60+Integer.parseInt(spl[2]);
    }
}
