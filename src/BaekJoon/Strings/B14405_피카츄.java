package BaekJoon.Strings;

import java.util.Scanner;

public class B14405_피카츄 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next(); //piqkapi
        int i=0;
        while(i<s.length()){
            if(i+1<s.length() && s.charAt(i)=='p'&&s.charAt(i+1)=='i') i+=2;
            else if(i+1<s.length() && s.charAt(i)=='k'&&s.charAt(i+1)=='a') i+=2;
            else if(i+2<s.length() && s.charAt(i)=='c'&&s.charAt(i+1)=='h'&&s.charAt(i+2)=='u') i+=3;
            else {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }


}
