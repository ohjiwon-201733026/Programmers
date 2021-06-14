package study.week6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 점프와순간이동 {

    public static void main(String[] args) {
        int N=6;
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        int [] dp=new int [n+1];
        int answer=0;
        Arrays.fill(dp,99999);

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        dp[0]=0;

        while(!q.isEmpty()){
            int x= q.poll();

            if(x==n) {
                break;
            }

            for(int i=0;i<2;++i){
                if(i==1){
                    for(int k=1;k<=n-x;++k){
                        int tmp=x+k; // k칸 앞으로
                        if(0<=tmp && tmp<=n){
                            if(dp[tmp]>dp[x]+k){
                                dp[tmp]=dp[x]+k;
                                q.add(tmp);
                            }
                        }
                    }
                }
                if(i==0){
                    int tmp=x*2;

                    if(0<=tmp && tmp<=n){
                        if(dp[tmp]>dp[x]) {
                            dp[tmp]=dp[x];
                            q.add(tmp);
                        }
                    }
                }
            }
        }


        return dp[n];
    }
}
