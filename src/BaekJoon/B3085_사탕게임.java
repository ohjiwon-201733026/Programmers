package BaekJoon;

import java.util.Scanner;

public class B3085_사탕게임 {
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        char [][] arr=new char [n][n];

        for(int i=0;i<n;++i){
            String s=sc.next();
            for(int j=0;j<n;++j){
                arr[i][j]=s.charAt(j);
            }
        }

        int answer=0;

        for(int i=0;i<n-1;++i){
            for(int j=0;j<n;++j){
                char tmp=arr[i][j];
                arr[i][j]=arr[i+1][j];
                arr[i+1][j]=tmp;
                int candy=longestCandy(arr);
                answer=Math.max(answer,candy);
                tmp=arr[i][j];
                arr[i][j]=arr[i+1][j];
                arr[i+1][j]=tmp;
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                char tmp=arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=tmp;
                int candy=longestCandy(arr);
                answer=Math.max(answer,candy);
                tmp=arr[i][j];
                arr[i][j]=arr[i][j+1];
                arr[i][j+1]=tmp;

            }
        }
        System.out.println(answer);

    }

    public static void print(char [][] arr){
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int longestCandy(char [][] arr){
        int ans=0;
        int max=0;
        char pre;
        for(int i=0;i<n;++i){
            pre=arr[i][0];
            max=1;
            for(int j=1;j<n;++j){
                if(pre==arr[i][j]) max++;
                else{
                    ans=Math.max(ans,max);
                    pre=arr[i][j];
                    max=1;
                }
            }
            ans=Math.max(ans,max);
        }

        for(int i=0;i<n;++i){
            pre=arr[0][i];
            max=1;
            for(int j=1;j<n;++j){
                if(pre==arr[j][i]) max++;
                else{
                    ans=Math.max(ans,max);
                    pre=arr[j][i];
                    max=1;
                }
            }
            ans=Math.max(ans,max);
        }

        return ans;
    }
}
