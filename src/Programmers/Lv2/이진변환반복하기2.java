package Programmers.Lv2;

public class 이진변환반복하기2 {
    public static void main(String [] args){
        String s="1111111";
        int []result =solution(s);
//        System.out.println(toBin(1));
        System.out.println(result[0]+" "+result[1]);
    }

    public static int [] solution(String s){
        int zeroCnt=0;
        int chCnt=0;

        while(true){
            if(s.equals("1")) break;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();++i){
                if(s.charAt(i)=='0') zeroCnt++;
                else sb.append("1");
            }
            int length=sb.length();
            s=Integer.toBinaryString(length);

            chCnt++;
        }
        int [] answer=new int [2];
        answer[0]=chCnt;
        answer[1]=zeroCnt;
        return answer;
    }
}
