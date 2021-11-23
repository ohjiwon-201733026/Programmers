package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while(T-->0){ // 100
            String p=br.readLine();
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();

            String ans=solution(p,n,str);
            sb.append(ans+"\n");

        }

        System.out.println(sb.toString());


    }

    private static String solution(String p, int n, String str) {
        String [] arr=str.substring(1,str.length()-1).split(",");
        boolean flag=true;
        int left=0,right=arr.length-1;
        if(str.equals("[]")){
            left=0;right=-1;
        }
        StringBuilder sb=new StringBuilder("[");
        for(int i=0;i<p.length();++i){ // 100,000
            char c=p.charAt(i);

            if(c=='R'){
                flag=flag?false:true;
            }
            if(c=='D'){
                if(left>right){
                    return "error";
                }
                else{
                    if(flag) left++;
                    else right--;
                }
            }
        }
        if(flag){
            for(int i=left;i<=right;++i) {
                if(i==right) sb.append(arr[i]);
                else sb.append(arr[i]+",");
            }
        }
        else{
            for(int i=right;i>=left;--i) {
                if(i==left) sb.append(arr[i]);
                else sb.append(arr[i]+",");
            }
        }

        return sb.append("]").toString();
    }
}
