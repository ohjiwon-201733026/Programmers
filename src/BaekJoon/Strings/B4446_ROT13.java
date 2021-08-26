package BaekJoon.Strings;

import java.util.HashMap;
import java.util.Scanner;

public class B4446_ROT13 {

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(solution(s));

    }

    public static String solution(String s){
        char [] mo={'a','i','y','e','o','u'};
        char [] za={'b' ,'k' ,'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g',
                'p', 'v' ,'j' ,'q' ,'t' ,'s' ,'r' ,'l', 'm' ,'f'};

        HashMap<String,String> map=new HashMap<>();

        for(int i=0;i<mo.length;++i){
            int j=i+3;
            if(j>mo.length-1) j-=mo.length;
            map.put(mo[j]+"",mo[i]+"");
            map.put((""+mo[j]).toUpperCase(),(""+mo[i]).toUpperCase());
        }

        for(int i=0;i<za.length;++i){
            int j=i+10;
            if(j>za.length-1) j-=za.length;
            map.put(""+za[j],""+za[i]);
            map.put((""+za[j]).toUpperCase(),(""+za[i]).toUpperCase());
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(check(c)){
                String t=c+"";
                sb.append(map.get(t));
            }
            else {
                String t=c+"";
                sb.append(t);
            }
        }

        return sb.toString();


    }
    public static boolean check(char c){
        boolean flag=false;
        if('A'<=c && c<='Z') flag=true;
        if('a'<=c && c<='z') flag=true;

        return flag;
    }
}
