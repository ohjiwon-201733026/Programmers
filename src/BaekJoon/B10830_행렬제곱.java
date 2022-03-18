package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B10830_행렬제곱 {

    static int n;
    static int [][] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        long b=sc.nextLong();
        arr=new int [n][n];


        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j]=sc.nextInt()%1000;
            }
        }

        int [][] answer=recur(arr,b);

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                System.out.print(answer[i][j]%1000+" ");
            }
            System.out.println();
        }


    }

    public static int [][] recur(int [][] tmp,long b){
        if(b==1L) return tmp;

        int [][] ret=recur(tmp,b/2);

        ret=matrixInter(ret,ret);

        if(b%2==1){
            ret=matrixInter(ret,tmp);
        }

        return ret;

    }

    public static int [][] matrixInter(int [][] a, int [][] b){
        int [][] result=new int[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                for(int k=0;k<n;++k) {
                    result[i][j]+= a[i][k]*b[k][j];
                    result[i][j]%=1000;
                }
            }
        }
        return result;
    }
}
