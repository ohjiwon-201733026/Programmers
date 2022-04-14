package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1509_팰린드롬분할 {

    static boolean [][] pal;
    static int [] dp;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        dp=new int [s.length()+1];
        pal=new boolean [s.length()+1][s.length()+1];

        palindrome(s);
    }

    static void palindrome(String s){

        for(int i=1;i<=s.length();++i){
            for(int j=i;j<=s.length();++j){
                boolean flag=true;
                int start=i-1,end=j-1;
                while (start<=end){
                    if(s.charAt(start)!=s.charAt(end)){
                        flag=false;
                        break;
                    }
                    start++;
                    end--;
                }

                pal[i][j]=flag;
            }
        }
    }

}
