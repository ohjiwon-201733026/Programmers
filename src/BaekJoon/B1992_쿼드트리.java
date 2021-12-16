package BaekJoon;

import java.util.Scanner;

public class B1992_쿼드트리 {
    static int [][] arr;
    static String s="";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        arr=new int [N][N];

        for(int i=0;i<N;++i){
            String s=sc.next();
            for(int j=0;j<N;++j){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        recur(0,0,N);


        System.out.println(s);

    }

    static void recur(int x, int y,int len){

        if(full(x,y,len)){
            s+=+arr[x][y];
            return;
        }
        else{
            s+="(";
            int n=len/2;
            recur(x,y,len/2);
            recur(x,y+n,len/2);
            recur(x+n,y,len/2);
            recur(x+n,y+n,len/2);
            s+=")";
        }

    }

    static boolean full(int x, int y, int len){
        int n=arr[x][y];
        for(int i=x;i<x+len;++i){
            for(int j=y;j<y+len;++j){
                if(arr[i][j]!=n) return false;
            }
        }
        return true;
    }

    static void check(int x, int y,int len){
        int n=arr[x][y];
        for(int i=x;i<x+len;++i){
            for(int j=y;j<y+len;++j){
                arr[i][j]=2;
            }
        }
        arr[x][y]=n;
    }
}
