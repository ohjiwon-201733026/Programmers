package Programmers.Lv2;

public class N진수게임 {
    public static void main(String[] args) {
        int n=16; // 진법
        int t=16; // 미리 구할 숫 자의 개수
        int m=2; // 게임에 참가하는 인원
        int p=1; // 튜브의 순서
        System.out.println(solution(n,t,m,p));
    }

    public static String solution(int n,int t, int m, int p){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<=t*m;++i){
            sb.append(toN(n,i));
        }
        String speak=sb.toString();
        StringBuilder answer=new StringBuilder();

        for(int i=0;i<t;++i){
           answer.append(speak.charAt((p-1)+i*m));
        }
        return answer.toString();
    }
    public static String [] Ox={"0","1","2","3","4","5","6"
            ,"7","8","9","A","B","C","D","E","F"};
    public static String toN(int n,int i){
        StringBuilder sb=new StringBuilder();
        do{
            sb.append(Ox[i%n]);
            i/=n;
        }while(i!=0);

        return sb.reverse().toString();

    }
}
