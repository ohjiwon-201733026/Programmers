package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2252_줄세우기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        int [] indegree=new int[N+1];
        ArrayList<Integer>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;++i) list[i]=new ArrayList<>();

        for(int i=0;i<M;++i){
            int x=sc.nextInt();
            int y=sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=N;++i){
            if(indegree[i]==0) queue.add(i);
        }

        while(!queue.isEmpty()){
            System.out.print(queue.peek()+" ");
            int current=queue.poll();

            for(int i=0;i<list[current].size();++i){
                int next=list[current].get(i);
                indegree[next]--;
                if(indegree[next]==0) queue.add(next);
            }
        }
    }
}
