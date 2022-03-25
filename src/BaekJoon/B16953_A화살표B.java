package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16953_A화살표B {
    static boolean flag=false;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long A=sc.nextLong();
        long B=sc.nextLong();

//        bfs(A,B);

        dfs(A,B,0);
        if(!flag) System.out.println(-1);
    }
    static void dfs(long a, long target, int cnt){
        if(a==target){
            flag=true;
            System.out.println(cnt+1);
        }

        long num=a;
        num*=2;
        if(num<=target) dfs(num,target,cnt+1);

        num=a;
        num=10*num+1;
        if(num<=target) dfs(num,target,cnt+1);
    }


    static void bfs(long a, long b){
        Queue<long [] > q=new LinkedList<>();
        q.add(new long []{a,0});

        while (!q.isEmpty()){
            long [] cur=q.poll();

            if(cur[0]==b){
                System.out.println(cur[1]+1);
                return;
            }

            for(int i=0;i<2;++i){
                long num=cur[0];

                if(i==0) num*=2;
                if(i==1) num=10*num+1;

                if(num<=b) q.add(new long[]{num,cur[1]+1});
            }
        }

        System.out.println(-1);
    }

}
