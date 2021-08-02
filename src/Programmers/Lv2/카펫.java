package Programmers.Lv2;

public class 카펫 {

    public static void main(String[] args) {
        int brown=10;
        int yellow=2;
        int [] a=solution(brown,yellow);
        System.out.println(a[0]+" "+a[1]);
    }

    public static int [] solution(int brown, int yellow){
        int [] answer=new int [2];
        int num=0;
        int i=0;
        for(i=1;i<=Math.sqrt(yellow);++i){

            if(yellow%i==0){
                num=i*2+yellow/i*2+4;
            }
            if(num==brown) break;
        }

        answer[0]=i>=yellow/i?i+2:yellow/i+2;
        answer[1]=i<yellow/i?i+2:yellow/i+2;
        return answer;
    }
}
