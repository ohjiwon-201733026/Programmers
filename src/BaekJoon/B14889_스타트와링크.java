package BaekJoon;

import java.util.Scanner;

public class B14889_스타트와링크 {

    static int n;
    static int [][] arr;
    static int answer;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int [n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j]=sc.nextInt();
            }
        }
        answer=Integer.MAX_VALUE;

        comb(new boolean[n],0,n,n/2);
        System.out.println(answer);
    }

    private static void comb( boolean[] visited, int start, int n, int r) {
        if(r==0){
            int s=getS(visited,true);
            int l=getS(visited,false);
            answer=Math.min(answer,Math.abs(s-l));
            return;
        }

        for(int i=start;i<n;++i){
            if(visited[i]!=true){
                visited[i]=true;
                comb(visited,i+1,n,r-1);
                visited[i]=false;
            }
        }
    }

    public static int getS(boolean [] check, boolean flag){
        int sum=0;
        for(int i=0;i<n;++i){
            if(check[i]==flag){
                for(int j=i+1;j<n;++j){
                    if(check[j]==flag){
                        sum+=arr[i][j]+arr[j][i];
                    }
                }
            }
        }

        return sum;
    }
}
