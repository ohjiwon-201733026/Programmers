package BaekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1766_문제집 {
    static List<List<Integer>> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        for(int i=0;i<=n;++i){
            list.add(new ArrayList<>());
        }

        int [] indegree=new int [n+1];

        for(int i=0;i<m;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();

            list.get(a).add(b);
            indegree[b]++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<indegree.length;++i){
            if(indegree[i]==0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            int x=pq.poll();

            for (Integer next : list.get(x)) {
                indegree[next]--;

                if(indegree[next]==0) pq.add(next);
            }
        }




    }
}
