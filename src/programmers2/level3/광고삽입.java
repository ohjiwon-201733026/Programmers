package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 광고삽입 {

    @Test
    public void test(){
        Assertions.assertEquals("01:30:59",solution("02:03:55","00:14:15",new String []{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        Assertions.assertEquals("01:00:00",solution("99:59:59","25:00:00",new String []{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
        Assertions.assertEquals("00:00:00",solution("50:00:00","50:00:00",new String []{"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
    }

    public String solution(String play_time,String adv_time, String [] logs){
        int playTime=strToSec(play_time);
        int advTime=strToSec(adv_time);
        int [] count=new int [playTime+1];

        for (String log : logs) {
            String [] spl=log.split("-");
            int startViewTime=strToSec(spl[0]);
            int endViewTime=strToSec(spl[1]);

            for(int i=startViewTime;i<endViewTime;++i) count[i]++;
        }

        int start=0;
        int end=advTime;
        long sum=0;
        for(int i=0;i<end;++i) sum+=count[i];

        long max=sum;
        int maxStartTime=0;
        while(end<=playTime){
            sum-=count[start];
            sum+=count[end];
            if(sum>max){
                max=sum;
                maxStartTime=start+1;
            }
            start++;
            end++;
        }
        return timeToStr(maxStartTime);
    }

    public String timeToStr(int time){
        int H=time/3600;
        int M=(time%3600)/60;
        int S=(time%3600)%60;
        return String.format("%02d:%02d:%02d",H,M,S);
    }

    public int strToSec(String time){
        String [] spl=time.split(":");
        return Integer.parseInt(spl[0])*3600+Integer.parseInt(spl[1])*60+Integer.parseInt(spl[2]);
    }

}
