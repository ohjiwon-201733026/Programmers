package BaekJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16953_A화살표B {
    static boolean flag=false;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();

        dfs(a,b,1);
        if(!flag) System.out.println(-1);

//        System.out.println(bfs(a,b));
    }

    public static long bfs(long a, long target){
        Queue<long[]> q=new LinkedList<>();
        q.add(new long []{a,1});

        while (!q.isEmpty()){
            long [] cur=q.poll();
            long A=cur[0];
            long cnt=cur[1];

            if(A==target){
                return cnt;
            }

            if(A>target) continue;

            for(int i=0;i<2;++i){
                long num=A;
                if(i==0) num=num*2;
                if(i==1) num=10*num+1;

                if(num<=target) q.add(new long []{num,cnt+1});
            }

        }

        return -1;
    }

    public static void dfs(long a, long b, int cnt){
        if(a==b){
            System.out.println(cnt);
            flag=true;
            return;
        }

        if(a>b) return;

        dfs(a*2,b,cnt+1);
        dfs(10*a+1,b,cnt+1);
    }

}
