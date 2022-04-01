package BaekJoon;

import java.util.*;

public class B2252_줄세우기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<Integer> [] list=new ArrayList[n+1];
        for(int i=0;i<=n;++i) list[i]=new ArrayList<>();
        int [] inDegree=new int [n+1];

        for(int i=0;i<m;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            list[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=1;i<=n;++i){
            if(inDegree[i]==0) q.add(i);
        }

        while (!q.isEmpty()){
            System.out.print(q.peek()+" ");
            int cur=q.poll();


            for (Integer next : list[cur]) {
                inDegree[next]--;
                if(inDegree[next]==0) q.add(next);
            }
        }

    }
}
