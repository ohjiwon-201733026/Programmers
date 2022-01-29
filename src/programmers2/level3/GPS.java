package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GPS {

    @Test
    public void test(){
        Assertions.assertEquals(1,solution(7,10,new int [][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}
        ,6,new int []{1, 2, 3, 3, 6, 7}));
        Assertions.assertEquals(1,solution(7,10,new int [][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}
                ,6,new int []{1, 2, 4, 6, 5, 7}));
    }

    public int solution(int n,int m, int [][] edge_list,int k,int [] gps_log){
        final int INF=Integer.MAX_VALUE;
        int [][] road=new int [n+1][n+1];

        for(int i=0;i<edge_list.length;++i){
            int s= edge_list[i][0];
            int e=edge_list[i][1];
            road[s][e]=1;
            road[e][s]=1;
        }

        int [][] dp=new int [k][n+1];
        for(int i=0;i<k;++i){
            for(int j=0;j<n+1;++j){
                dp[i][j]=INF;
            }
        }

        dp[0][gps_log[0]]=0;
        for(int i=1;i<k;++i){
            for(int j=1;j<n+1;++j){
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]); // 이동을 하지 않을 경우 확인

                for(int node=1;node<n+1;node++){ // 이동을 할 경우
                    if(road[j][node]==1){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][node]);
                    }
                }
                if(j!=gps_log[i]) dp[i][j]++;
            }
        }

        if(dp[k-1][gps_log[k-1]]<INF) return dp[k-1][gps_log[k-1]];
        else return -1;
    }
}
