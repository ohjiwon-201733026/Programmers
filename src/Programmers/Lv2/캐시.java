package Programmers.Lv2;

import java.util.*;

public class 캐시 {
    public static void main(String [] args){
        int cacheSize=0;
        String [] cities={
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize,cities));
    }

    public static int solution(int cacheSize, String [] cities) {
        int time = 0;
        ArrayList<String> list=new ArrayList<>();
        if(cacheSize==0) return cities.length*5;
        for(String city :cities){
            city=city.toUpperCase();
            if(list.contains(city)){ // cache hit
                time++;
                list.remove(city);
                list.add(city);
            }
            else{ // cache miss
                if(list.size()<cacheSize){
                    list.add(city);

                }
                else{
                    list.remove(0);
                    list.add(city);
                }
                time+=5;
            }
        }

        return time;

    }
}
