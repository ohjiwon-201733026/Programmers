package Programmers.Lv2;

public class _124나라의숫자 {

    public static void main(String[] args) {
        int n=4;
        String answer=solution(n);
        System.out.println(answer);
    }
    public static int [] m={4,1,2};
    public static String solution(int n){
        String answer="";

        while(n>0){
            answer=m[n%3]+answer;
            n=(n-1)/3;
        }

        return answer;
    }

    public static String recur(int n){
        if(n==0) return "";
        int num,mod; // 몫, 나머지
        if(n%3==0) num=n/3-1;
        else num=n/3;

        mod=n%3;

        return recur(num)+m[mod];
    }
}
