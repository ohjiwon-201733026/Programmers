package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1005_ACMCraft {
    static int n;
    static int [] d;
    static ArrayList<Integer> [] arr;
    static int [] indegree;
    static int [] ans;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();


        while (t-->0){
            n=sc.nextInt(); // 건물 개수
            int k=sc.nextInt(); // 규칙 개수

            d=new int [n+1];
            indegree=new int [n+1];
            ans=new int [n+1];
            arr=new ArrayList[n+1];
            for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

            for(int i=1;i<=n;++i) d[i]=sc.nextInt();
            while (k-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                arr[a].add(b);
                indegree[b]++;
            }

            int w=sc.nextInt();

            bfs(w);

            System.out.println(ans[w]);

        }



    }


    public static void bfs(int w){
        Queue<Node> q=new LinkedList<>();
        for(int i=1;i<=n;++i){
            if(indegree[i]==0){
                q.add(new Node(i,d[i]));
                ans[i]=d[i];
            }
        }

        while (!q.isEmpty()){
            Node cur=q.poll();

            for (Integer next : arr[cur.num]) {
                ans[next]=Math.max(ans[next],cur.cnt+d[next]);
                indegree[next]--;

                if(indegree[next]==0){
                    q.add(new Node(next,ans[next]));
                }
            }
        }
    }

    static class Node{
        int num,cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }


}
