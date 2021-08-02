package Programmers.Lv3;

import java.util.*;

public class 셔틀버스 {

    public static void main(String[] args) {
        int n=10;
        int t=60;
        int m=45;
        String [] timetable={"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};


//        for(String s: timetable){
//            System.out.println(s);
//        }
        String ans=solution(n,t,m,timetable);
        System.out.println(ans);
    }

    public static int sorting(String o1, String o2) {
        String [] a =o1.split(":");
        String [] b=o2.split(":");

        if(( o1.equals("23:59")|| a[0].equals("24") )&& ( o2.equals("23:59")|| b[0].equals("24")) ){

            if(a[0].equals(b[0])) return Integer.parseInt(a[1])-Integer.parseInt(b[1]);

            return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
        }

        if(( o1.equals("23:59")|| a[0].equals("24") )&& ( ! o2.equals("23:59")|| !b[0].equals("24")) ){
            return -1;
        }

        if(( !o1.equals("23:59")|| !a[0].equals("24") )&& (o2.equals("23:59")|| b[0].equals("24")) ){
            return 1;
        }

        if(Integer.parseInt(a[0])==Integer.parseInt(b[0])) return Integer.parseInt(a[1])-Integer.parseInt(b[1]);

        return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
    }


    public static String solution(int n, int t, int m, String [] timetable){
        String answer="";
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        ArrayList<String> shuttleTime=new ArrayList<>();

        // 버스 도착 시간
        int busH=9;
        int busM=0;
        map.put("09:00",new ArrayList<>());
        shuttleTime.add("09:00");
        for(int i=1;i<n;++i){
            busM+=60;
            if(busM>=60) { busM-=60; busH++; };
            String time=String.format("%02d:%02d",busH,busM);
            shuttleTime.add(time);
            map.put(time,new ArrayList<>());
        }
        // 셔틀 순서대로
        Collections.sort(shuttleTime, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] a =o1.split(":");
                String [] b=o2.split(":");

                if(a[0].equals(b[0])) return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
                return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
            }
        });

        // 크루 온 순서대로 정렬
        Arrays.sort(timetable, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] a =o1.split(":");
                String [] b=o2.split(":");

                if(( o1.equals("23:59")|| a[0].equals("24") )&& ( o2.equals("23:59")|| b[0].equals("24")) ){

                    if(a[0].equals(b[0])) return Integer.parseInt(a[1])-Integer.parseInt(b[1]);

                    return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
                }

                if(( o1.equals("23:59")|| a[0].equals("24") )&& ( ! o2.equals("23:59")|| !b[0].equals("24")) ){
                    return -1;
                }

                if(( !o1.equals("23:59")|| !a[0].equals("24") )&& (o2.equals("23:59")|| b[0].equals("24")) ){
                    return 1;
                }

                if(Integer.parseInt(a[0])==Integer.parseInt(b[0])) return Integer.parseInt(a[1])-Integer.parseInt(b[1]);

                return Integer.parseInt(a[0])-Integer.parseInt(b[0]);
            }
        });

        int j=0; // shuttle idx
        for(int i=0;i< timetable.length;++i){
            if(map.get(shuttleTime.get(j)).size()==m) j++;
            String [] a=timetable[i].split(":");
            String [] b=shuttleTime.get(j).split(":");
            // 23:59에는 집으로 돌아감
            if(timetable[i].equals("23:59")) continue;
            int num=sorting(timetable[i],shuttleTime.get(j));
            if(num>0) j++;
            if(j>shuttleTime.size()) break;
            map.get(shuttleTime.get(j)).add(timetable[i]);
        }

        String lastTime=shuttleTime.get(shuttleTime.size()-1);
        if(map.get(lastTime).size()<m) answer=lastTime;
        else {
            String [] lastCrew=map.get(lastTime).get(m-1).split(":");
            int lastCrewH=Integer.parseInt(lastCrew[0]);
            int lastCrewM=Integer.parseInt(lastCrew[1]);
            lastCrewM--;
            if(lastCrewM<0) { lastCrewM+=60; lastCrewH--; };
            answer=String.format("%02d:%02d",lastCrewH,lastCrewM);
        }




        return answer;
    }
}
