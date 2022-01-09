package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 셔틀버스 {

    @Test
    public void test(){
//        Assertions.assertEquals("09:00",solution(1,1,5,new String []{"08:00", "08:01", "08:02", "08:03"}));
//        Assertions.assertEquals("09:09",solution(2,10,2,new String []{"09:10", "09:09", "08:00"}));
//        Assertions.assertEquals("08:59",solution(2,1,2,new String []{"09:00", "09:00", "09:00", "09:00"}));
        Assertions.assertEquals("00:00",solution(1,1,5,new String []{"00:01", "00:01", "00:01", "00:01", "00:01"}));
//        Assertions.assertEquals("09:00",solution(1,1,1,new String []{"23:59"}));
//        Assertions.assertEquals("18:00",solution(10,60,45,new String []{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
    static Map<Integer, Stack<Integer>> map=new HashMap<>();
    static ArrayList<Integer> busStop=new ArrayList<>(); // 버스 도착 시간
    static PriorityQueue<Integer> crewArrived=new PriorityQueue<>();
    String solution(int n, int t, int m, String [] timetable){
        int start=540;
        map.put(start,new Stack<>());
        busStop.add(start);
        for(int i=0;i<n-1;++i){
            start+=t;
            map.put(start,new Stack<>());
            busStop.add(start);
        }

        // timetable 정렬
        for (String s : timetable) {
            int crew=strToMin(s);
            crewArrived.add(crew);
        }
        int key=0;
        while(key<n){
            if(crewArrived.isEmpty()) break;
            int crew=crewArrived.poll();
            while(busStop.get(key) < crew || map.get(busStop.get(key)).size()>=m){

                key++;
                if(key>=n){
                    break;
                }

            }
            if(key!=n)
            map.get(busStop.get(key)).add(crew);
        }


        int last=busStop.get(busStop.size()-1);
        if(map.get(last).size()==m) {
            return minToString(map.get(last).pop()-1);
        }
        else return minToString(last);


    }

    String minToString(int n){
        return String.format("%02d:%02d",n/60,n%60);
    }

    int strToMin(String s){
        String [] a=s.split(":");
        return Integer.parseInt(a[0])*60+Integer.parseInt(a[1]);
    }
}
