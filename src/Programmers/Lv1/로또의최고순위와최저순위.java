package Programmers.Lv1;

import java.util.ArrayList;

public class 로또의최고순위와최저순위 {

    public static void main(String[] args) {
        int [] lottos={45, 4, 35, 20, 3, 9};
        int [] win_nums={20, 9, 3, 45, 4, 35};
        int [] answer=solution(lottos,win_nums);
        for(int i=0;i<2;++i) {
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int [] answer = new int [2];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<win_nums.length;++i){
            list.add(win_nums[i]);
        }
        int cnt=0;
        int zeroCount=0;
        for(int i=0;i<lottos.length;++i){
            if(list.contains(lottos[i])) cnt++;
            if(lottos[i]==0) zeroCount++;
        }

        int first=6-(cnt+zeroCount)+1;
        if(first>=6) first=6;
        int last=6-cnt+1;
        if(last>=6) last=6;
        answer[0]=first;
        answer[1]=last;

        return answer;
    }
}
