package BaekJoon;

import java.util.*;

public class B2252_줄세우기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<Integer>[] arr=new ArrayList[n+1];
        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        int [] indegree=new int [n+1];

        for(int i=0;i<m;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;++i){
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            int cur=q.poll();

            for(int i=0;i<arr[cur].size();++i){
                int next=arr[cur].get(i);
                indegree[next]--;
                if(indegree[next]==0) q.add(next);
            }
        }
    }
}
