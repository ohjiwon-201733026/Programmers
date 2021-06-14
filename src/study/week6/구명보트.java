package study.week6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class 구명보트 {

    public static void main(String[] args) {
        int [] people={70, 80, 50};
        int limit=100;
        System.out.println(solution(people,limit));
    }

    private static int solution(int[] people, int limit) {
        int answer=0;

        Arrays.sort(people);
        int min=0;
        for(int max=people.length-1;min<=max;--max){
            if(people[min]+ people[max]<=limit){
                min++;
            }
            answer++;
        }
        return answer;
    }

    private static int solution2(int[] people, int limit) {
        int answer=0;

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<people.length;++i){
            list.add(people[i]);
        }

        Collections.sort(list,Collections.reverseOrder());

        while(list.size()!=0){ // 다 옮길때 까지
            int onBoat=0; // 보트 위

            onBoat=list.get(0);
            list.remove(0);

            for(int i=list.size()-1;i>=0;--i){ // 한바퀴 돌면서 한대에 탈 수 있는 사람 다 태우기
                if(onBoat+list.get(i)<=limit){
                    onBoat+=list.get(i);
                    list.remove(i);
                    i--;
                }else break;
            }

            answer++; // 보트 한대 추가

        }

        return answer;
    }


}
