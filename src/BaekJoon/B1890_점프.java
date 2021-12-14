package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1890_점프 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] arr=new int [N][N];

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                arr[i][j]=sc.nextInt();
            }
        }

        long [][] dp=new long[N][N];
        dp[0][0]=1;
        loop:
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                if(i==N-1 && j==N-1) break loop;
                int x=i+arr[i][j];
                int y=j+arr[i][j];

                if(0<=x && x<N) dp[x][j]+=dp[i][j];
                if(0<=y && y<N) dp[i][y]+=dp[i][j];
            }
        }

        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
