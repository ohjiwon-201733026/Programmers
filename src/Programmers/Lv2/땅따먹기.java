package Programmers.Lv2;

public class 땅따먹기 {

    public static void main(String[] args) {
        int [][] land={{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }
    // 1 2 3 5
    // 10 11 12 11
    // 16 3 2 1
    public static int solution(int [][] land){
        int [][] dp=new int [land.length][4];

        for(int i=0;i<4;++i){
            dp[0][i]=land[0][i];
        }

        for(int i=1;i< land.length;++i){
            for(int j=0;j<4;++j){
                dp[i][j]=minVal(dp,i,j)+land[i][j];
            }
        }
        int answer=0;
        for(int i=0;i<4;++i){
            if(answer<dp[land.length-1][i]) answer=dp[land.length-1][i];
        }

        return answer;
    }

    public static int minVal(int [][] dp, int i,int j){
        int max=0;

        for(int k=0;k<4;++k){
            if(j!=k){
                if(max<dp[i-1][k]) max=dp[i-1][k];
            }
        }

        return max;
    }
}


