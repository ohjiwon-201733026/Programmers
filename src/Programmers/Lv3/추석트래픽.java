package Programmers.Lv3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 추석트래픽 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
    }

    public int solution(String [] lines){
        ArrayList<Integer> startTime=new ArrayList<>();
        ArrayList<Integer> endTime=new ArrayList<>();
        int answer=0;
        for(String line:lines){
            String [] t=line.split(" ");
            int end=toMillis(t[1]);
            String s=t[2].substring(0,t[2].length()-1);
            int term=(int)(Double.parseDouble(s)*1000);
            int start=end-term+1;

            startTime.add(start);
            endTime.add(end);

        }

        for(int i=0;i< lines.length;++i) {
            int cnt = 0;
            int startSection = startTime.get(i);
            int endSection = startSection + 1000;

            for (int j = 0; j < lines.length; ++j) {
                int start = startTime.get(j);
                int end = endTime.get(j);

                if (startSection <= start && start < endSection) cnt++;
                else if (startSection <= end && end < endSection) cnt++;
                else if (start <= startSection && endSection <= end) cnt++;
            }

            answer = cnt > answer ? cnt : answer;
        }

            for(int i=0;i<lines.length;++i){
                int cnt=0;
                int startSection=endTime.get(i);
                int endSection=startSection+1000;

                for(int j=0;j<lines.length;++j){
                    int start=startTime.get(j);
                    int end=endTime.get(j);

                    if (startSection <= start && start < endSection) cnt++;
                    else if (startSection <= end && end < endSection) cnt++;
                    else if (start <= startSection && endSection <= end) cnt++;
                }
                answer=cnt>answer?cnt:answer;
        }



        return answer;
    }



    private int toMillis(String time) {
        // time: 01:00:04.002
        String [] a=time.split("\\.");
        String [] b=a[0].split(":");
        int millis=(Integer.parseInt(b[0])*3600+Integer.parseInt(b[1])*60+Integer.parseInt(b[2]))*1000+Integer.parseInt(a[1]);

        return millis;
    }
}
