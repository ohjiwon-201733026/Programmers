package BaekJoon.Implementation;

import java.util.Scanner;

public class 상어초등학교 {
    public static void  main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][] prefer=new int [n*n][4];
        for(int i=0;i<n*n;++i){
            prefer[i][0]=sc.nextInt();
            prefer[i][1]=sc.nextInt();
            prefer[i][2]=sc.nextInt();
            prefer[i][3]=sc.nextInt();
        }
        int answer=solution(n,prefer);
    }
    public static int [] dx={0,1,0,-1};
    public static int [] dy={1,0,-1,0};
    private static int solution(int n, int[][] like_list) {
        int [][] map=new int [n][n];
        return 0;
    }
}
