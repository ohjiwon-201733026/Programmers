package study.week8;

public class 땅따먹기 {

    public static int [][] dp;
    int solution(int[][] land) {
        int answer = 0;
        int n=land.length-1;

        dp=new int[land.length][4];
        for(int i=0;i<4;++i) dp[0][i]=land[0][i];

        for(int i=1;i<land.length;++i){ // 1행부터
            for(int j=0;j<4;++j){
                dp[i][j]=max(i,j)+land[i][j];
            }
        }


        for(int j=0;j<4;++j){
            if(answer<dp[n][j]) answer=dp[n][j];
        }


        return answer;
    }

    public static int max(int i, int j){
        int num=0;
        for(int x=0;x<4;++x){
            if(x==j) continue;
            if(dp[i-1][x]>num) num=dp[i-1][x];
        }

        return num;
    }
}
