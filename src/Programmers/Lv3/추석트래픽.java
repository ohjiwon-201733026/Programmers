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
            String[] time= line.split(" ");
            String [] tmp=time[1].split(":");
            int end=(int)((3600*Integer.parseInt(tmp[0])+60*Integer.parseInt(tmp[1])+Double.parseDouble(tmp[2]))*1000);
            int term=(int)(Double.parseDouble(time[2].substring(0,time[2].length()-1))*1000)-1;
            int start=end-term;
            startTime.add(start);
            endTime.add(end);
        }

        for(int i=0;i<lines.length;++i){
            int cnt=0;
            int startSection=startTime.get(i);
            int endSection=startSection+1000;

            for(int j=0;j<lines.length;++j){
                int start=startTime.get(j);
                int end=endTime.get(j);

                if(startSection<= start && start <endSection) cnt++;
                else if(startSection<= end && end< endSection) cnt++;
                else if(start <= startSection && endSection <= end) cnt++;
            }

            answer=cnt>answer?cnt:answer;
        }

        for(int i=0;i<lines.length;++i){
            int cnt=0;
            int startSection=endTime.get(i);
            int endSection=startSection+1000;

            for(int j=0;j<lines.length;++j){
                int start=startTime.get(j);
                int end=endTime.get(j);

                if(startSection<= start && start <endSection) cnt++;
                else if(startSection<= end && end<endSection) cnt++;
                else if(start <= startSection && endSection <= end) cnt++;
            }

            answer=cnt>answer?cnt:answer;
        }

        return answer;
    }


}
