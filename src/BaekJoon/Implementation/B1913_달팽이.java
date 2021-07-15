package BaekJoon.Implementation;

import java.util.Scanner;

public class B1913_달팽이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w=sc.nextInt();
        int [][] arr=new int[w+1][w+1];
        int findn=sc.nextInt();

        int [] x={1,0,-1,0};
        int [] y={0,1,0,-1};
        int now=0;

        int nx=1;
        int ny=1;
        int num=w*w;
        int fx=1;
        int fy=1;

        while(num>0){
            arr[nx][ny]=num;
            if(num==findn){
                fx=nx; fy=ny;
            }

            if(nx+x[now]>=arr.length || ny+y[now]>=arr.length || nx+x[now]<1 || ny+y[now]<1 || arr[nx+x[now]][ny+y[now]]!=0){
                if(now==3) now=0;
                else now+=1;
            }
            nx+=x[now];
            ny+=y[now];
            num--;


        }
        for(int i=1;i<=w;++i) {
            for (int j = 1; j <= w; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(fx+" "+fy);
    }
}
