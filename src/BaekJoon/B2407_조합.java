package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class B2407_조합 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

//        int a=n-m;
//        int max=a>m?a:m;
//        int min=a<m?a:m;
//
//        BigInteger x=factorial(max+1,n);
//        BigInteger y=factorial(1,min);
//
//        System.out.println(x.divide(y));

        dp=new BigInteger[1001][1001];

        setDp(n,m);

        System.out.println(dp[n][m]);
    }

    public static BigInteger factorial(int start,int end){
        BigInteger num=BigInteger.ONE;
        for(int i=start;i<=end;++i){
            num=num.multiply(new BigInteger(String.valueOf(i)));
        }

        return num;
    }
    public static BigInteger [][] dp;
    public static void setDp(int n, int m){

        for(int i=1;i<=n;++i){
            for(int j=0;j<=i;++j){
                if(j==0 || i==j) {
                    dp[i][j]=new BigInteger("1");
                }
                else{
                    dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
                }
            }
        }
    }
}
