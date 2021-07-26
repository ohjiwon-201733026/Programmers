package BaekJoon.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B20210_파일탐색기 {
    public static ArrayList<String> list=new ArrayList<>();
    public static HashMap<Character,Integer> hm=new HashMap<>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int num=1;
        for(char c='A';c<='Z';++c){
            hm.put(c,num);
            hm.put((char)(c+32),++num);
            num++;
        }

        while(T-->0){
            String s=sc.next();
            list.add(s);
        }

        Collections.sort(list,(a,b)->{
            ArrayList<String> aList=divideNum(a);
            ArrayList<String> bList=divideNum(b);
            int n=aList.size()< bList.size()? aList.size() : bList.size();
            for(int i=0;i<n;++i){
                String A=aList.get(i);
                String B=bList.get(i);
                if(A.equals(B)) continue;


                Long aLong,bLong;
                if(isNum(A)&& isNum(B)) {
                    aLong=Long.parseLong(A);
                    bLong=Long.parseLong(B);
                    if(aLong==bLong) return A.length()-B.length();
                    return (int) (aLong-bLong);
                }
                if(isNum(A)&&!isNum(B)) return -1;
                if(!isNum(A)&&isNum(B)) {System.out.println(i);return 1;}

                return hm.get(A.charAt(0))-hm.get(B.charAt(0));
            }
            return 0;

        });

        System.out.println(list);

    }

    public static boolean isNum(String s){
        if('0'<=s.charAt(0) && s.charAt(0)<='9' ) return true;
        return false;
    }

    public static ArrayList<String> divideNum(String a){
        ArrayList<String> l=new ArrayList<>();
        char [] s=a.toCharArray();
        StringBuilder tmp=new StringBuilder();
        boolean flag=false;
        for(int i=0;i<s.length;++i){
            if('0'<=s[i] && s[i]<='9'){
                tmp.append(s[i]);
                flag=true;
            }
            else{
                if(flag) { l.add(tmp.toString()); flag=false; tmp=new StringBuilder();}
                l.add(s[i]+"");
            }
        }
        if(flag) l.add(tmp.toString());

        return l;
    }
}
