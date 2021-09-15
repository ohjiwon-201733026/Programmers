package Programmers.Lv3;

public class GPS {
    public static void main(String[] args) {
        int n=7;
        int m=10;
        int [][] edge_list={{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
        int k=6;
        int [] gps_log={1,2,3,3,6,7};
        System.out.println(solution(n,m,edge_list,k,gps_log));
    }
    static int INF=99999999;
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int [][] road=new int [n+1][n+1];

        for(int i=0;i< edge_list.length;++i){
            int s=edge_list[i][0],e=edge_list[i][1];
            road[s][e]=1;road[e][s]=1;
        }
        // dp[i][j]=N : i번째 인덱스에 j 노드가 온다면 gps_log의 0번인덱스부터 i번 인덱스까지 총 N번 달랐다
        int [][] dp=new int [k][n+1];
        for(int i=0;i<k;++i){
            for(int j=0;j<n+1;++j){
                dp[i][j]=INF;
            }
        }

        dp[0][gps_log[0]]=0;

        for(int i=1;i<k;++i){
            for(int j=1;j<n+1;++j){
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);

                for(int node=1;node<n+1;++node){
                    if(road[node][j]==1){
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
