package BaekJoon;

import java.util.*;

public class B11725_트리의부모찾기 {

    public static int [] parent,dist;
    public static ArrayList<Integer> [] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new ArrayList[n+1];
        parent=new int [n+1];

        for(int i=0;i<=n;++i) arr[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs(1);

       for(int i=2;i<parent.length;++i){
            System.out.println(parent[i]);
        }

    }

    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        parent[start]=start;
        while (!q.isEmpty()){
            int cur=q.poll();

            for (Integer integer : arr[cur]) {
                if(parent[integer]==0){
                    parent[integer]=cur;
                    q.add(integer);
                }

            }
        }
    }




}
