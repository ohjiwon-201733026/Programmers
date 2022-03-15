package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1967_트리의지름 {

    static ArrayList<Node> [] arr;
    static int [] dist;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new ArrayList[n+1];

        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        dist=new int[n+1];
        visited=new boolean[n+1];
        dist[1]=0;
        dfs(1,0);

        int maxNodeIdx=0;
        int maxNodeVal=0;
        for(int i=0;i<dist.length;++i){
            if(dist[i]>maxNodeVal){
                maxNodeIdx=i;
                maxNodeVal=dist[i];
            }
        }

        dist=new int [n+1];
        visited=new boolean[n+1];
        dist[maxNodeIdx]=0;
        dfs(maxNodeIdx,0);

        int answer=0;
        for (int i : dist) {
            answer=Math.max(answer,i);
        }

        System.out.println(answer);

    }
    public static void dfs(int start,int weight){
        visited[start]=true;

        for (Node node : arr[start]) {
            if(!visited[node.end]){
                dist[node.end]=node.weight+weight;
                dfs(node.end,dist[node.end]);
            }
        }

    }

    static class Node{
        int end,weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
