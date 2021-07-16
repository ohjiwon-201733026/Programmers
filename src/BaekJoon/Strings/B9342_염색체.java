package BaekJoon.Strings;

import java.util.Scanner;

public class B9342_염색체 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        String regex="[A-F]?A+F+C+[A-F]?$";
        while(T-->0){
            String s=sc.next();

            if(s.matches(regex)) System.out.println("Infected!");
            else System.out.println("Good");
        }
    }
}
