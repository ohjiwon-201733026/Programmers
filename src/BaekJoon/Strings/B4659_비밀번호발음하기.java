package BaekJoon.Strings;

import java.util.Scanner;

public class B4659_비밀번호발음하기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        countMo("zoggax");
//        for(int i=0;i<arr.length;++i) System.out.println(arr[i]);
//        System.out.println(countThree("zoggax"));

        while(true){
            String s=sc.next();

            if(s.equals("end")) break;

            if(countMo(s) && countTwo(s) && countThree(s)) System.out.println("<"+s+"> is acceptable.");
            else System.out.println("<"+s+"> is not acceptable.");
        }


    }

    private static boolean countThree(String s) {
        char pre=s.charAt(0);
        for(int i=1;i<s.length();++i){
            char c=s.charAt(i);
            if(c==pre){
                if(c!='e' && c!='o') return false;
                else pre=c;
            }
            else pre=c;
        }
        return true;
    }

    public static boolean [] arr;
    private static boolean countTwo(String s) {
        boolean pre=arr[0];
        int flag=1;
        for(int i=1;i<s.length();++i){
            if(flag>=3) return false;
            if(pre==arr[i]) flag++;
            else { flag=1; pre=arr[i]; }
        }
        if(flag>=3) return false;
        return true;

    }

    private static boolean countMo(String s) {
        arr=new boolean [s.length()];
        boolean flag=false;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='a'|| c=='e' || c=='i' || c=='o' || c=='u') { arr[i]=true; flag=true; }

        }
        return flag;
    }


}
