package BaekJoon.Strings;

import java.util.Scanner;

public class B3029_경고 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String now=sc.next();
        String thro=sc.next();

        System.out.println(solution(now,thro));
    }

    private static String solution(String now, String thro) {
        String [] n=now.split(":");
        String [] t=thro.split(":");
        int [] intN=new int[3];
        int [] intT=new int[3];
        for(int i=0;i<3;++i){
            intN[i] = Integer.parseInt(n[i]);
            intT[i] = Integer.parseInt(t[i]);
        }
        if(now.equals(thro)) return "24:00:00";
        int s=intT[2]-intN[2];
        if(s<0) { s+=60; intT[1]--; };
        int m=intT[1]-intN[1];
        if(m<0) { m+=60; intT[0]--; };
        int h=intT[0]-intN[0];
        if(h<0) h+=24;


        return String.format("%02d:%02d:%02d",h,m,s);

    }
}
