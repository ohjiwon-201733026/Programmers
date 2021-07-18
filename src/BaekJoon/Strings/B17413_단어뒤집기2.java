package BaekJoon.Strings;

import java.util.Scanner;

public class B17413_단어뒤집기2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='<') {
                sb.append(c);
                i++;
                while(true){
                    if(i==s.length()-1) break;
                    c=s.charAt(i);
                    if(c=='>'){sb.append(c);break;}
                    else sb.append(c);
                    i++;
                }
                if(i==s.length()-1) sb.append(">");

            }
            else{
                StringBuilder tmp=new StringBuilder();
                tmp.append(c);
                while(true){
                    if(i==s.length()-1) break;
                    c=s.charAt(++i);
                    if(c=='<') {sb.append(tmp.reverse());i--;break;}
                    else if(c==' ') { sb.append(tmp.reverse()+" "); tmp=new StringBuilder();}
                    else tmp.append(c);

                }
                if(i==s.length()-1) sb.append(tmp.reverse());
            }

        }

        return sb.toString();
    }
}
