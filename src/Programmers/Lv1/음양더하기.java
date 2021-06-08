package Programmers.Lv1;

public class 음양더하기 {

    public static void main(String[] args) {
        int [] absolutes={1,2,3};
        boolean [] signs={false,false,true};
        int answer=solution(absolutes,signs);
        System.out.print(answer);
    }

    private static int solution(int[] absolutes, boolean[] signs) {
        int answer=0;

        for(int i=0;i<absolutes.length;++i){
            if(signs[i]) answer+=absolutes[i];
            else answer-=absolutes[i];
        }
        return answer;

    }
}
