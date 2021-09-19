package Programmers.Lv2;

public class 피보나치수 {

    public static void main(String[] args) {
        int n=1;
        System.out.println(solution(n));
    }
    static int [] fb;
    public static int solution(int n){
        fb=new int [n+1];
        recur(n);
        return fb[n];
    }

    public static int recur(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(fb[n]!=0) return fb[n];

        return fb[n]=fb[n-1]+fb[n-2];
    }
}
