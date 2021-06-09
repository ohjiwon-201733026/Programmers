package Programmers.Lv1;

import java.util.ArrayList;


public class 모의고사 {

    public static void main(String[] args) {
        int [] answers={};
        int [] answer=solution(answers);
        for(int i=0;i<answer.length;++i) System.out.println(answer[i]);
    }

    private static int[] solution(int[] answers) {
        int [] score=new int [3];
        int [] one=new int [answers.length];
        int cnt=0;
        //1번
        for(int i=0;i<answers.length;++i){
            one[i]=i%5+1;
            if(answers[i]==one[i]) cnt++;
        }
        score[0]=cnt;
        cnt=0;
        //2번
        int [] tmp={1,3,4,5};
        int k=0;
        for(int i=0;i<answers.length;++i){
            if(i%2==0) one[i]=2;
            else {
                if(k>=4) k=0;
                one[i]=tmp[k];
                k++;
            }
        }
        for(int i=0;i<answers.length;++i){
            if(one[i]==answers[i]) cnt++;
        }
        score[1]=cnt;
        //3번
        cnt=0;
        k=0;
        int [] a={3,1,2,4};
        for(int i=0;i< answers.length;i+=2){
            if(k>=4) k=0;
            one[i]=a[k];
            if(i+1< answers.length) one[i+1]=a[k];
            k++;
        }
        for(int i=0;i< answers.length;++i){
            if(one[i]==answers[i]) cnt++;
        }

        score[2]=cnt;
        int max=0;
        for(int i=0;i< score.length;++i){
            if(score[i]>max) {
                max=score[i];
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i< score.length;++i){
            if(score[i]==max) list.add(i+1);
        }
        int [] answer=new int [list.size()];
        for(int i=0;i<list.size();++i){
            answer[i]=list.get(i);
        }

        return answer;

    }
}
