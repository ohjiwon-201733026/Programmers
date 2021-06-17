package study.week6;

public class 이진변환반복하기_ {
    public static void main(String[] args) {
        String s="110010101001";
        int [] answer=solution(s);
        System.out.println(answer[0]+" "+answer[1]);
    }

    private static int [] solution(String s) {
        int [] answer =new int [2];
        int zeroCount=0;
        int changeCnt=0;

        while(true){
            int oneCount=0;
            if(s.equals("1")) break;
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)=='0') zeroCount++;
                else oneCount++;
            }
            s=Integer.toBinaryString(oneCount);
            changeCnt++;

        }
        answer[0]=changeCnt;
        answer[1]=zeroCount;

        return answer;
    }
}
