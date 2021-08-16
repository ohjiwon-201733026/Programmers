package Programmers.Lv2;

import java.util.Arrays;

public class 구명보트Re {
    public static void main(String [] args){
        int [] people={70,80,50};
        int limit=100;
        System.out.println(solution(people,limit));
    }

    public static int solution(int [] people, int limit){
        int answer=0;
        boolean [] visit=new boolean[people.length];
        Arrays.sort(people);
        int min=0;
        for(int max= people.length-1;min<=max;--max){
            if(people[min]+people[max]<=limit) min++;
            answer++;
        }

        return answer;
    }


}
