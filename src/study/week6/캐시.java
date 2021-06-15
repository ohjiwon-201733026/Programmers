package study.week6;

import java.util.ArrayList;


public class 캐시 {

    public static void main(String[] args) {
        int cacheSize=3;
        String [] cities={"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int ans=solution(cacheSize,cities);
        System.out.println(ans);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache=new ArrayList<>();

        if(cacheSize==0) return 5*cities.length;

        for(int i=0;i<cities.length;++i){
            String city=cities[i].toLowerCase();

            if(!cache.contains(city)) {
                answer+=5;
                if(cache.size()<cacheSize) cache.add(city);
                else{
                    cache.remove(0);
                    cache.add(city);
                }
            }
            else {
                answer++;
                if(cache.size()<cacheSize) cache.add(city);
                else{
                    cache.remove(cache.indexOf(city));
                    cache.add(city);
                }
            }
        }
        return answer;
    }
}
