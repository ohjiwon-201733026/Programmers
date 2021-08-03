package Programmers.Lv3;

import java.util.*;

public class 셔틀버스 {

    public static void main(String[] args) {
        int n=10;
        int t=60;
        int m=45;
        String [] timetable={"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        String ans=solution(n,t,m,timetable);
        System.out.println(ans);
    }

    public static HashMap<Integer, Stack<Integer>> map;
    public static Queue<Integer> queue;
    public static int[] keys;
    public static int[] times;
    public static String solution(int n, int t, int m, String[] timetable) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        keys = new int[n];
        times = new int[timetable.length];
        for(int i = 0; i < times.length; i++){
            times[i] = changeTimeToInt(timetable[i]);
        }
        Arrays.sort(times);
        for(int time: times){
            queue.add(time);
        }

        for(int i = 0; i < n; i++){
            map.put(540 + t * i, new Stack<>());
            keys[i] = 540 + t * i;
        }

        int key_cnt = 0;
        while (key_cnt < n){
            if(queue.isEmpty())
                break;
            if(keys[key_cnt] >= queue.peek() && map.get(keys[key_cnt]).size() < m){
                map.get(keys[key_cnt]).push(queue.poll());
            }else{
                key_cnt++;
            }
        }

        if(map.get(keys[keys.length-1]).size() < m){
            return changeTimeToString(keys[keys.length-1]);
        }
        else{
            return changeTimeToString(map.get(keys[keys.length-1]).peek()-1);
        }
    }
    public static int changeTimeToInt(String time){
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
    }

    public static String changeTimeToString(int time){
        String hours = Integer.toString(time/60);
        String minutes = Integer.toString(time%60);
        hours = hours.length() < 2 ? "0"+hours : hours;
        minutes = minutes.length() < 2 ? "0"+minutes : minutes;
        return hours+":"+minutes;
    }
}
