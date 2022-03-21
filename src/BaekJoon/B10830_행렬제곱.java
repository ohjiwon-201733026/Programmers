package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B10830_행렬제곱 {
    static int n;
    static long b;
    static int [][] a;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        b=sc.nextLong();

        a=new int[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                a[i][j]=sc.nextInt()%1000;
            }
        }
        int [][] answer=recur(b);

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                System.out.print(answer[i][j]%1000+" ");
            }
            System.out.println();
        }
    }

    public static int [][] recur(long b){
        if(b==1) return a;

        int [][] ret=recur(b/2);

        ret=intersect(ret,ret);

        if(b%2==1){
            ret=intersect(ret,a);
        }

        return ret;
    }

    public static int [][] intersect(int [][] a, int [][] b){
        int [][] tmp=new int [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int sum=0;
                for(int k=0;k<n;++k){
                    sum+=a[i][k]*b[k][j];
                }
                tmp[i][j]=sum%1000;
            }

        }
        return tmp;
    }
}
