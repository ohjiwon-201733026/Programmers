package BaekJoon.Implementation;

import java.util.Scanner;

public class B2753_윤년 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int answer=solution(n);
        System.out.println(answer);
    }

    public static int solution(int n){
        int answer=0;

        if(n%4==0 && n%100!=0) answer=1;
        if(n%400==0) answer=1;

        return answer;
    }
}
