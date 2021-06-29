package study.week8;

public class 다음큰숫자 {

    public int solution(int n) {
        int answer = 0;

        String s=Integer.toBinaryString(n);
        int count=countOne(s);

        for(int i=n+1;i<=1000000;++i){
            String st=Integer.toBinaryString(i);
            if(count==countOne(st)) {
                answer=i;
                break;
            }
        }
        // System.out.println(countOne(s));
        return answer;
    }

    public static int countOne(String s){
        int answer=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='1') answer++;
        }

        return answer;
    }
}
