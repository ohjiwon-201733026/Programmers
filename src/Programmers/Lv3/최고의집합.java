package Programmers.Lv3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 최고의집합 {

    @Test
    public void test(){
        int [] answer=solution(2,1);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int [] solution(int n, int s){
        int p=s/n;

        if(s<n) return new int []{-1};

        int [] answer=new int [n];
        Arrays.fill(answer,p);

        for(int i=n-1;i>=n-s%n;--i){
            answer[i]++;
        }

        return answer;
    }


}
