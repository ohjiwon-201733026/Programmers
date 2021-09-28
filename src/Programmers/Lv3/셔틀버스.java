package Programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 셔틀버스 {

    HashMap<Integer,Stack<Integer>> bus=new HashMap<>();
    ArrayList<Integer> busOrder=new ArrayList<>();
    PriorityQueue<Integer> crewArrived=new PriorityQueue<>();
    public String solution(int n, int t, int m, String[] timetable) {
        int start=timeToInt("09:00");
        for(int i=0;i<n;++i){
            busOrder.add(start+t*i);
            bus.put(start+i*t,new Stack<>());
        }
        for(int i=0;i<timetable.length;++i){
            crewArrived.add(timeToInt(timetable[i]));
        }
        int key_cnt=0;
        while(key_cnt<n){
            if(crewArrived.isEmpty()) break;
            if(bus.get(busOrder.get(key_cnt)).size()<m && busOrder.get(key_cnt)>=crewArrived.peek()) bus.get(busOrder.get(key_cnt)).add(crewArrived.poll());
            else key_cnt++;
        }

        int last=busOrder.get(busOrder.size()-1);
        if(bus.get(last).size()<m) return intToTime(last);
        else if(bus.get(last).size()==m) return intToTime(bus.get(last).pop()-1);


        for (Integer key : bus.keySet()) {
            System.out.println( key+" : "+bus.get(key));
        }
        return "";
    }

    private String intToTime(int last) {
        int H=last/60;
        int M=last%60;

        return String.format("%02d:%02d",H,M);

    }

    private int timeToInt(String time){
        String [] t=time.split(":");
        int H=Integer.parseInt(t[0]);
        int M=Integer.parseInt(t[1]);
        return H*60+M;
    }

    @Test
    public void test(){
//        Assertions.assertEquals("09:00",solution(1,1,5,new String []{"08:00", "08:01", "08:02", "08:03"}));
        Assertions.assertEquals("09:09",solution(2,10,2,new String []{"09:10", "09:09", "08:00"}));
//        Assertions.assertEquals("08:59",solution(2,1,2,new String []{"09:00", "09:00", "09:00", "09:00"}));
//        Assertions.assertEquals("00:00",solution(1,1,5,new String []{"00:01", "00:01", "00:01", "00:01", "00:01"}));
//        Assertions.assertEquals("09:00",solution(1,1,1,new String []{"23:59"}));
//        Assertions.assertEquals("18:00",solution(10,60,45,new String []{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
}
