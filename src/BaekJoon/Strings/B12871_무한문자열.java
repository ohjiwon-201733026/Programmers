package BaekJoon.Strings;

import java.util.Scanner;

public class B12871_무한문자열 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t= sc.next();

        System.out.println(solution(s,t));
    }

    public static int solution(String s, String t){
        if(s.length()==t.length()){
            if(s.equals(t)) return 1;
            else return 0;
        }

        int lcm=lcm(s.length(),t.length());

        StringBuilder S=new StringBuilder(s);
        StringBuilder T=new StringBuilder(t);

        for(int i=0;i<lcm/s.length()-1;++i) S.append(s);
        for(int i=0;i<lcm/t.length()-1;++i) T.append(t);

        if(S.toString().equals(T.toString())) return 1;
        else return 0;


    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
