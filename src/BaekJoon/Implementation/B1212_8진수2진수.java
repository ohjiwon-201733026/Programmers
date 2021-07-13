package BaekJoon.Implementation;

import java.util.Scanner;

public class B1212_8진수2진수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int n=Integer.parseInt(s);
        System.out.print(solution(n));
    }

    private static String solution(long n) {
        String answer="";
        answer=decToBin(octTodec(n));

        return answer;
    }

    private static int octTodec(long n){
        String oct=Long.toString(n);
        int num=0;
        int len=oct.length()-1;
        for(int i=oct.length()-1;i>=0;--i){

            num+=Math.pow(8,len-i)*(oct.charAt(i)-'0');
        }

        return num;
    }

    private static String decToBin(long n){
        String answer="";
        do{
            long mod=n%2;
            n/=2;
            answer=mod+answer;
        }while(n!=0);

        return answer;
    }
}
