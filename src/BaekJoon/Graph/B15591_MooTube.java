package BaekJoon.Graph;

import java.util.*;

public class B15591_MooTube {
    static final int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt(), Q=sc.nextInt();

        List<int []>[] adj=new ArrayList[N+1];

        for(int i=1;i<=N;++i){
            adj[i]=new ArrayList<>();
        }

        for(int i=1;i<N;++i){
            int p=sc.nextInt(), q=sc.nextInt(), r=sc.nextInt();
            adj[p].add(new int []{q,r});
            adj[q].add(new int []{p,r});
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<Q;++i){
            int k=sc.nextInt(), v=sc.nextInt();

            boolean [] visited=new boolean[N+1];
            visited[v]=true;
            Queue<Integer> q=new LinkedList<>();
            q.add(v);

            int ans=0;
            while(!q.isEmpty()){
                int cur=q.poll();

                for(int [] a:adj[cur]){
                    if(!visited[a[0]] && a[1]>=k){
                        q.add(a[0]);
                        visited[a[0]]=true;
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }





}
