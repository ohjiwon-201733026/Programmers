package Programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 셔틀버스 {

    @Test
    public void test(){
//        Assertions.assertEquals("09:00",solution(1,1,5,new String []{"08:00", "08:01", "08:02", "08:03"}));
        Assertions.assertEquals("09:09",solution(2,10,2,new String []{"09:10", "09:09", "08:00"}));
//        Assertions.assertEquals("08:59",solution(2,1,2,new String []{"09:00", "09:00", "09:00", "09:00"}));
//        Assertions.assertEquals("00:00",solution(1,1,5,new String []{"00:01", "00:01", "00:01", "00:01", "00:01"}));
//        Assertions.assertEquals("09:00",solution(1,1,1,new String []{"23:59"}));
//        Assertions.assertEquals("18:00",solution(10,60,45,new String []{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
    static PriorityQueue<Integer> crewArrived=new PriorityQueue<>();
    static ArrayList<Integer> list=new ArrayList<>();
    static HashMap<Integer,Stack<Integer>> hm=new HashMap<>();
    public String solution(int n, int t, int m, String [] timetable){
        int start=stringToTime("09:00");
        for(int i=0;i<n;++i){
            int time=start+t*i;
            hm.put(time,new Stack<>());
            list.add(time);
        }
        // timetable 정렬
        for (String s : timetable) {
            int crew=stringToTime(s);
            crewArrived.add(crew);
        }

        int key=0;
       while(key<n){
           if(crewArrived.isEmpty()) break;
           if(hm.get(list.get(key)).size()<m && crewArrived.peek()<=list.get(key)){
               hm.get(list.get(key)).add(crewArrived.poll());
           }
           else key++;
       }

        int last=list.get(list.size()-1);
       if(hm.get(last).size()==m) {
           last=hm.get(last).pop()-1;

       }
        return timeToString(last);

    }

    private String timeToString(int t){
        int H=t/60;
        int M=t%60;

        return String.format("%02d:%02d",H,M);
    }

    private int stringToTime(String s){
        String [] a=s.split(":");
        return Integer.parseInt(a[0])*60+Integer.parseInt(a[1]);
    }
}
