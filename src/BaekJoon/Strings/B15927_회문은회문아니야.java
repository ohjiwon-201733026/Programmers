package BaekJoon.Strings;

import java.util.Locale;
import java.util.Scanner;

public class B15927_회문은회문아니야 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int max=-1;
        if(!isPal(s)) max=s.length();
        else{
            if(!same(s)) max=s.length()-1;
        }

        System.out.println(max);
    }
    public static boolean same(String s){
        String c=""+s.charAt(0);
        s=s.replaceAll(c,"");
        if(s.length()==0) return true;
        else return false;
    }

    public static boolean isPal(String t){
        if(t.length()%2==0){
            String a=t.substring(0,t.length()/2);
            StringBuilder b=new StringBuilder();
            b.append(t.substring(t.length()/2)).reverse();
            if(a.equals(b.toString())) return true;
        }
        else{
            String a=t.substring(0,t.length()/2);
            StringBuilder b=new StringBuilder();
            b.append(t.substring(t.length()/2+1)).reverse();
            if(a.equals(b.toString())) return true;
        }
        
        return false;
    }
}
