package BaekJoon.Strings;

import java.util.Scanner;

public class B1942_디지털시계 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<3;++i){
            String s=sc.nextLine();
            int n=solution(s);
            System.out.println(n);
        }
    }

    public static int solution(String s){
        int answer=0;
        String [] a=s.split(" ");
        String start=a[0];
        String end=a[1];
        String tmp=start;
        while(!tmp.equals(end)){
            String [] b=tmp.split(":");
            int [] c=new int [3];
            c[0]=Integer.parseInt(b[0]);
            c[1]=Integer.parseInt(b[1]);
            c[2]=Integer.parseInt(b[2]);

            if(Integer.parseInt(""+c[0]+c[1]+c[2])%3==0) answer++;

            c[2]++;
            if(c[2]>=60) { c[2]-=60; c[1]++;}
            if(c[1]>=60) {c[1]-=60; c[0]++;}
            if(c[0]>=24) {c[0]-=24;}
            String h=c[0]+"",m = c[1]+"",sec=c[2]+"";
            if(0<=c[0] && c[0]<=9) h="0"+c[0];
            if(0<=c[1] && c[1]<=9) m="0"+c[1];
            if(0<=c[2] && c[2]<=9) sec="0"+c[2];

            tmp=h+":"+m+":"+sec;

        }

        String [] b=tmp.split(":");
        int [] c=new int [3];
        c[0]=Integer.parseInt(b[0]);
        c[1]=Integer.parseInt(b[1]);
        c[2]=Integer.parseInt(b[2]);

        if(Integer.parseInt(""+c[0]+c[1]+c[2])%3==0) answer++;

        return answer;
    }
}
