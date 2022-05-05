package BaekJoon;

import java.util.Scanner;

public class B2011_암호코드 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=s.length();

        long [] dp=new long [n+1];

        if(s.charAt(0)=='0') {
            System.out.println(0);
        }
        else if(s.charAt(s.length()-1)=='0' && s.charAt(s.length()-2)!='2' && s.charAt(s.length()-2)!='1'){
            System.out.println(0);
        }
        else{
            dp[0]=dp[1]=1;
            for(int i=2;i<=n;++i){
                int tmp=s.charAt(i-1)-'0';

                if(tmp>0){
                    dp[i]=dp[i-1]%1000000;
                }

                tmp+=(s.charAt(i-2)-'0')*10;
                if(tmp>=10 && tmp<=26){
                    dp[i]=(dp[i]+dp[i-2])%1000000;
                }
            }

            System.out.println(dp[n]);
        }
    }
}
