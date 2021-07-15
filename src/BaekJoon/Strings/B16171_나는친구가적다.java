package BaekJoon.Strings;

import java.util.Scanner;

public class B16171_나는친구가적다 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String keyword=sc.next();
        System.out.println(solution(s,keyword));
    }

    private static int solution(String s, String keyword) {
        s=s.replaceAll("[0-9]","");
        if(s.contains(keyword)) return 1;
        else return 0;

    }
}
