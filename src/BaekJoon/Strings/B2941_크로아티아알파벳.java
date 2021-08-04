package BaekJoon.Strings;

import java.util.Scanner;

public class B2941_크로아티아알파벳 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        s=s.replaceAll("c=","A");
        s=s.replaceAll("c-","A");
        s=s.replaceAll("dz=","A");
        s=s.replaceAll("d-","A");
        s=s.replaceAll("lj","A");
        s=s.replaceAll("nj","A");
        s=s.replaceAll("s=","A");
        s=s.replaceAll("z=","A");
        System.out.println(s.length());

    }
}
