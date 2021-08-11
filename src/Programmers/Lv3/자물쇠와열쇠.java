package Programmers.Lv3;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int [][] key={{0,0,0},{1,0,0},{0,1,1}};
        int [][] lock={{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(solution(key,lock));
    }
    public static boolean [][] flag;
    public static boolean solution(int [][] key, int [][] lock){
        boolean answer=false;
        int m=key.length;
        int n=lock.length;
        int [][]lock2=new int [n+(m-1)*2][n+(m-1)*2];
        flag=new boolean [n+(m-1)*2][n+(m-1)*2];
        for(int i=m-1;i<m+n-1;++i){
            for(int j=m-1;j<m+n-1;++j){
                flag[i][j]=true;
                lock2[i][j]=lock[i-(m-1)][j-(m-1)];
            }
        }
        for(int i=0;i<=3;++i){
            key=rotation(key);
            for(int k=0;k<=lock2.length-key.length;++k){ // key의 0,0 위치
                for(int l=0;l<= lock2.length-key.length; ++l){
                    int [][] tmp=copy(lock2,lock2.length,m);

                    for(int x=0;x<m;++x){ // key 범위
                        for(int y=0;y<m;++y){
                            if(flag[k+x][l+y]){
                                if(lock2[k+x][l+y]==1&&key[x][y]==1) tmp[k+x][l+y]=2;
                                if(lock2[k+x][l+y]==1&&key[x][y]==0) tmp[k+x][l+y]=1;
                                if(lock2[k+x][l+y]==0&&key[x][y]==0) tmp[k+x][l+y]=2;
                                if(lock2[k+x][l+y]==0&&key[x][y]==1) tmp[k+x][l+y]=1;
                            }
                        }
                    }

                    if(check(tmp)) return true;
                }
            }

        }

        return false;
    }

    public static int [][] copy(int [][] a,int n,int m) {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                tmp[i][j] = a[i][j];
            }

        }
        return tmp;
    }

    public static boolean check(int [][] arr){

        for(int i=0;i<arr.length ;++i){
            for(int j=0;j<arr[0].length;++j){
                if(flag[i][j]){
                    if(arr[i][j]==2) return false;
                    if(arr[i][j]==0) return false;
                }
            }
        }

        return true;
    }

    public static int [][]  rotation(int [][] arr){
        int n= arr.length;
        int [][] rot=new int [n][n];
        // 90도씩 회전
        for(int i=0;i<n;++i){
            int [] t=arr[i]; // 1 2 3
            for(int j=0;j<n;++j){
                rot[j][n-i-1]=t[j];
            }
        }
        return rot;
    }
}
