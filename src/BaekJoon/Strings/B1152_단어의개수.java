package BaekJoon.Strings;

import java.util.Scanner;

public class B1152_단어의개수 {
    public static void  main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().trim();

        if(s.length()==0){
            System.out.println("0");
        }
        else {
            String[] a = s.split(" ");
            System.out.println(a.length);
        }
    }
}
