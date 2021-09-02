package BaekJoon.Strings;

import java.util.Scanner;

public class B12933_오리 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println(solution(s));
    }

    public static int solution(String s){
        int answer=-1;
        if(s.contains("quack")){
            s=s.replaceAll("quack","");
            answer=1;
        }

        for(int i=0;i<s.length();++i){

        }

        return answer;
    }
}
