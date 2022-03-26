package BaekJoon;

import java.util.Scanner;

public class B17144_미세먼지안녕 {
    static int n,m;
    static int [][] arr;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static int x1,x2;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int t=sc.nextInt();
        arr=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==-1 && x1==0) x1=i;
                else if(arr[i][j]==-1 && x1!=0) x2=i;
            }
        }

        while (t-->0){
            remove();
        }

        int answer=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(arr[i][j]!=-1) answer+=arr[i][j];
            }
        }

        System.out.println(answer);

    }

    public static void remove(){

        arr=extend_mircro();

        arr=air_condition();

    }

    public static int [][] air_condition(){

        int [][] tmp=copy();


        // 위
        for(int i=0;i<m-1;++i) tmp[x1][i+1]=arr[x1][i];
        for(int i=x1;i>0;--i) tmp[i-1][m-1]=arr[i][m-1];
        for(int i=m-1;i>0;--i) tmp[0][i-1]=arr[0][i];
        for(int i=1;i<=x1;++i) tmp[i][0]=arr[i-1][0];
        tmp[x1][0]=-1;

        // 아래
        for(int i=0;i<m-1;++i) tmp[x2][i+1]=arr[x2][i];
        for(int i=x2+1;i<=n-1;++i) tmp[i][m-1]=arr[i-1][m-1];
        for(int i=m-1;i>0;--i) tmp[n-1][i-1]=arr[n-1][i];
        for(int i=n-1;i>=x2;--i) tmp[i-1][0]=arr[i][0];
        tmp[x2][0]=-1;

        tmp[x1][1]=0;tmp[x2][1]=0;
        return tmp;
    }

    public static int [][] copy(){
        int [][] tmp=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                tmp[i][j]=arr[i][j];
            }
        }
        return tmp;
    }

    public static int [][] extend_mircro(){
        int [][] tmp=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(arr[i][j]!=0){
                    int n=arr[i][j]/5;
                    int a=0;
                    for(int k=0;k<4;++k){
                        int x=i+dx[k];
                        int y=j+dy[k];

                        if(check(x,y) && arr[x][y]!=-1){
                            tmp[x][y]+=n;
                            a++;
                        }
                    }

                    tmp[i][j]+=arr[i][j]-n*a;

                }
            }
        }

        return tmp;
    }

    public static boolean check(int x, int y){
        return 0<=x && x<n && 0<=y && y<m;
    }
}
