package Programmers.Lv2;

import java.util.ArrayList;

public class 기능개발 {

    public static void main(String[] args) {
        int [] progresses={95, 90, 99, 99, 80, 99};
        int [] speeds={1, 1, 1, 1, 1, 1};

        int [] answer=solution(progresses,speeds);
        for(int n:answer) System.out.println(n);

    }

    private static int[] solution(int[] progresses, int[] speeds) {

        int [] mod=new int [progresses.length];

        for(int i=0;i<mod.length;++i){
            mod[i]=(int)(Math.ceil((double)(100-progresses[i])/(speeds[i])));
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int pre=mod[0];
        int cnt=1;
        if(mod.length>1) {
            for (int i = 1; i < mod.length; ++i) {
                if (pre >= mod[i]) cnt++;
                else {
                    ans.add(cnt);
                    cnt = 1;
                    pre = mod[i];
                }
            }
            ans.add(cnt);
        }
        else ans.add(1);
        int [] answer=new int [ans.size()];
        for(int i=0;i<ans.size();++i) answer[i]=ans.get(i);

        return answer;
    }
}
