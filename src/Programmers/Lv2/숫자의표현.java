package Programmers.Lv2;

public class 숫자의표현 {
    public static void main(String[] args) {
        int n=15;
        System.out.println(solution(n)); // 4
    }
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    // 0
    public static int solution(int n){
        int [] dp=new int [n+1];
        int sum;
        for(int i=1;i<=n;++i){
            sum=0;
            for(int j=i;j<=n;++j){
                sum+=j;
                if(1<=sum & sum<=n) dp[sum]++;
            }
        }

        return dp[n];
    }
}
