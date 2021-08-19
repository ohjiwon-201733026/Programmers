package Programmers.Lv2;

public class 점프와순간이동 {
    public static void main(String [] args){
        int N=5000;
        System.out.println(solution(N));
    }
    public static int solution(int N){
        int answer=1;
        while(N!=1){
            if(N%2==0) N/=2;
            else {
                answer++;
                N--;
            }
        }

        return answer;
    }
}
