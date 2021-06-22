package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Collections;

public class 두개뽑아서더하기 {

    public static void main(String[] args) {
        int [] numbers={2,1,3,4,1};
        int [] ans=solution(numbers);
        for(int n:ans) System.out.println(n);
    }

    private static int[] solution(int[] numbers) {
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i< numbers.length-1;++i){
            for(int j=i+1;j< numbers.length;++j){
                int sum=numbers[i]+numbers[j];
                if(!list.contains(sum)) list.add(sum);

            }
        }

        Collections.sort(list);
        int [] answer=new int [list.size()];
        for(int i=0;i<list.size();++i) answer[i]=list.get(i);

        return answer;
    }
}
