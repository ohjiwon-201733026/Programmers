package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B3107_IPv6 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        int cnt=0;

        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c==':') sb.append(c);
            else{
                StringBuilder tmp=new StringBuilder();
                tmp.append(c);
                i++;
                while (i<s.length()){
                    char x=s.charAt(i);
                    if(x==':') {i--;break;}
                    tmp.append(x);
                    i++;
                }

                sb.append(change(tmp.toString()));
                cnt++;
            }
        }
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<8-cnt;++i){
            tmp.append(":0000");
        }
        tmp.append(":");
        String str=sb.toString();
        str=str.replace("::",tmp.toString());

        if(str.startsWith(":")) str=str.substring(1);
        if(str.endsWith(":")) str=str.substring(0,str.length()-1);

        System.out.println(str);

    }

    static String change(String str){
        StringBuilder sb=new StringBuilder();
        if(str.length()<4) {
            for (int i = 0; i < 4 - str.length(); ++i) {
                sb.append("0");
            }

            sb.append(str);
            return sb.toString();
        }
        else return str;
    }
}
