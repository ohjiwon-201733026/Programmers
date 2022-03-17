package BaekJoon;

import java.util.Scanner;

public class B9663_NQueen {

    static int n;
    static int [] chessMap;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        chessMap=new int [n];
        cnt=0;
        dfs(0);

        System.out.println(cnt);
    }

    // depth==열(j)
    public static void dfs(int depth){
        if(depth==n){
            cnt++;
            return;
        }

        for(int i=0;i<n;++i){
            chessMap[depth]=i;
            // 해당 열에서 i번째 행에 놓을 수 있는지 체크
            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col){

        for(int i=0;i<col;++i){
            if(chessMap[col]==chessMap[i]) return false;
            else if(Math.abs(col-i)==Math.abs(chessMap[col]-chessMap[i])) return false;
        }

        return true;
    }
}
