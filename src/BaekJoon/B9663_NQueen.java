package BaekJoon;

import java.util.Scanner;

public class B9663_NQueen {

    static int n;
    static int [] chessMap;
    static int answer=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        chessMap=new int [n];

        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int depth){
        if(depth==n){
            answer++;
            return;
        }

        for(int i=0;i<n;++i){
            chessMap[depth]=i;

            if(possible(depth)){
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col){

        for(int i=0;i<col;++i){
            if(chessMap[i]==chessMap[col]) return false;
            if(Math.abs(i-col)==Math.abs(chessMap[i]-chessMap[col])) return false;
        }

        return true;
    }

}
