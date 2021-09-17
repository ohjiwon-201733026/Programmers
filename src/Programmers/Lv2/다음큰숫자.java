package Programmers.Lv2;

public class 다음큰숫자 {
    public static void main(String[] args) {
        int n=78;
        System.out.println(solution(n));
    }

    public static int solution(int n){
        String bin=Integer.toBinaryString(n);
        int cnt=countOne(bin);
        for(int i=n+1;i<=1000000;++i){
            String b=Integer.toBinaryString(i);
            if(countOne(b)==cnt) return i;
        }
        return -1;
    }
    public static int countOne(String s){
        int cnt=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='1') cnt++;
        }

        return cnt;
    }
}
