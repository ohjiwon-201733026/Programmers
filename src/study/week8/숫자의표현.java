package study.week8;


public class 숫자의표현 {

    public static int solution(int n) {
        int answer = 0;
        int [] dp=new int [10001];
        int sum=0;
        for(int i=1;i<10001;++i){
            sum=0;
            for(int j=i;j<10001;++j){
                sum+=j;
                if(1<=sum && sum<10001) dp[sum]++;
            }
        }

        for(int i=1;i<=15;++i){
            System.out.print(dp[i]+" ");
        }
        return answer;
    }

    public static void main(String [] args) {
        int n=15;
        int ans=solution(15);
    }
}
