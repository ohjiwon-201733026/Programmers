package BaekJoon.Strings;

import java.util.Locale;
import java.util.Scanner;

public class B3615_JavaVsCpp {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(solution(s));
    }
// long_and_mnemonic_identifier
    // longAndMnemonicIdentifier
    public static String solution(String s){
        String t="";
        if(isCpp(s)) t=cppToJava(s);
        else if(isJava(s)) t=javaToCpp(s);
        else t="error!";

        return t;
    }

    public static boolean isCpp(String s){
        for(int i=0;i<s.length();++i){
            if(isUpperCase(s.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isJava(String s){
        if(isLowerCase(s.charAt(0)) && !s.contains(" ")) return true;
        else return false;
    }

    public static boolean isLowerCase(char c){
        if('a'<=c && c<='z') return true;
        return false;
    }

    public static boolean isUpperCase(char c){
        if('A'<=c && c<='Z') return true;
        return false;
    }

    public static String javaToCpp(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();++i){
            if(isUpperCase(s.charAt(i)))sb.append("_"+(""+s.charAt(i)).toLowerCase());
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String cppToJava(String s){

        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        boolean flag= false;
        for(int i=1;i<s.length();++i){
            if(flag) {
                sb.append((""+s.charAt(i)).toUpperCase());
                flag=false;
            }
            else if(s.charAt(i)=='_') { flag=true; }
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
