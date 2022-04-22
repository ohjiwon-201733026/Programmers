package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B6987_월드컵 {
    static final int MAX_TEAM_COUNT=6;
    static boolean isEndGame=false;
    static int [][] matches;

    public static void main(String args[]) throws IOException {
        Scanner sc=new Scanner(System.in);

        int tc=4;
        int size=0;
        for(int i=1;i<MAX_TEAM_COUNT;++i) size+=i;

        int idx=0;
        matches=new int [15][2];
        for(int i=0;i<5;++i){
            for(int j=i+1;j<6;++j){
                matches[idx][0]=i;
                matches[idx][1]=j;
                idx++;
            }
        }

        StringBuilder sb=new StringBuilder();
        while (tc-->0){
            int [][] worldCup=new int [6][3];
            boolean isPossible=true;
            for(int i=0;i<MAX_TEAM_COUNT;++i){
                int win=sc.nextInt();
                int draw=sc.nextInt();
                int lose=sc.nextInt();

                worldCup[i][0]=win;
                worldCup[i][1]=draw;
                worldCup[i][2]=lose;

                if(win+draw+lose!=5){
                    isPossible=false;
                    break;
                }
            }

            if(isPossible){
                backTracking(worldCup,0,size);
                if(isEndGame) sb.append(1);
                else sb.append(0);
            }
            else sb.append(0);

            isEndGame=false;
            sb.append(" ");
        }

        System.out.println(sb.toString());


    }

    public static void backTracking(int [][] worldCup, int depth, int size){
        if(depth==size){
            isEndGame=true;
            return;
        }

        int teamA=matches[depth][0];
        int teamB=matches[depth][1];

        if(worldCup[teamA][0]>0 && worldCup[teamB][2]>0){
            worldCup[teamA][0]--;
            worldCup[teamB][2]--;
            backTracking(worldCup,depth+1,size);
            worldCup[teamA][0]++;
            worldCup[teamB][2]++;
        }

        if(worldCup[teamA][1]>0 && worldCup[teamB][1]>0){
            worldCup[teamA][1]--;
            worldCup[teamB][1]--;
            backTracking(worldCup,depth+1,size);
            worldCup[teamA][1]++;
            worldCup[teamB][1]++;
        }

        if(worldCup[teamA][2]>0 && worldCup[teamB][0]>0){
            worldCup[teamA][2]--;
            worldCup[teamB][0]--;
            backTracking(worldCup,depth+1,size);
            worldCup[teamA][2]++;
            worldCup[teamB][0]++;
        }
    }
}
