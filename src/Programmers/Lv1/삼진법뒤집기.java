package Programmers.Lv1;

public class 삼진법뒤집기 {

    public static void main(String[] args) {
        int n=125;
        int answer=solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        String s="";
        int answer=0;
        while(n>=3){
            int a=n/3;
            int mod=n%3;
            s+=mod;
            n=a;
        }
        s+=n;
        for(int i=0;i<s.length();++i){
            int x=s.charAt(s.length()-1-i)-'0';

            answer+=x*Math.pow(3,i);
        }
        return answer;
    }
}
