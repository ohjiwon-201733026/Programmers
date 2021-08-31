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

    public static String solution(String play_time,String adv_time,String [] logs){
        int playTime=timeToSec(play_time);
        int advTime=timeToSec(adv_time);
        int num=0; // 시청자 수
        PriorityQueue<Log> pq=new PriorityQueue<>();
        for(String log:logs){ // pq에 넣기
            String [] s=log.split("-");
            pq.add(new Log(timeToSec(s[0]),'s'));
            pq.add(new Log(timeToSec(s[1]),'e'));
        }

        ArrayList<Time> times=new ArrayList<Time>();
        while(!pq.isEmpty()){
            Log l=pq.poll();
            if(l.time>playTime) break;
            if(l.c=='s') num++;
            else num--;
            int term=0;
            if(pq.isEmpty()) term=playTime-l.time;
            else term=pq.peek().time-l.time;

            times.add(new Time(l.time,term,num));
        }


        int answer=0;
        int MAX=0;
        for(int i=0;i<times.size();++i){
            Time t=times.get(i);
            int sum=times.get(i).term;
            int j=i+1;

            int max=t.term*t.num;
            while(sum!=advTime){
                if(j>=times.size()) break;
                if(sum>advTime) break;
                Time tmp=times.get(j);
                sum+=times.get(j).term;
                max+=(tmp.term*tmp.num);
                j++;
            }
            if(sum>advTime){
                j--;
               sum-=times.get(j).term;
               max-=(times.get(j).term*times.get(j).num);
               max+=(advTime-sum)*times.get(j).num;
            }
            if(j>=times.size()) continue;


            if(MAX<max) {
                MAX=max;
                answer=t.startTime;
            }

        }
        int H=answer/3600;
        int M=(answer%3600)/60;
        int S=(answer%3600)%60;
        return String.format("%02d:%02d:%02d",H,M,S);

    }
    public static class Time{
        int startTime;
        int term;
        int num;

        public Time(int startTime,int term,int num) {
            this.startTime=startTime;
            this.term = term;
            this.num=num;
        }
        // 누적 재생시간 계산 함수
        public int playTime(){
            return term*num;
        }
    }

    public static class Log implements Comparable<Log> {
        String startTime;
        int time;
        char c; // s(start) or e(end)

        public Log(int time, char c) {
            this.time = time;
            this.c = c;
        }

        @Override
        public int compareTo(Log o) {
            return this.time-o.time;
        }
    }

    public static int timeToSec(String time){
        String [] t=time.split(":");
        return Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
    }
}
