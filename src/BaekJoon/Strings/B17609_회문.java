package BaekJoon.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609_회문 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String t=br.readLine();
        int T=Integer.parseInt(t);
        String answer = "";
        while(T-->0){
            String s=br.readLine();

            int a=solution(s);
            answer+=a+"\n";
        }
        System.out.println(answer);
    }

    public static int solution(String s){

        boolean flag=false;

        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) flag=true; // 다름
            start++;
            end--;
        }
        if(!flag) return 0; // 회문 체크


        for(int i=0;i<s.length();++i){ // i를 뺀경우
            flag=false;
            String p=s.substring(0,i)+s.substring(i+1);

            start=0;
            end=p.length()-1;
            while(start<=end){
                if(p.charAt(start)!=p.charAt(end)) flag=true; // 다름
                start++;
                end--;
            }

            if(!flag) return 1;
        }

        return 2;
    }
}
