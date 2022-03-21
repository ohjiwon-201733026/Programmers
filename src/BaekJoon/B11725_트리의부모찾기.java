package BaekJoon;

import java.util.*;

public class B11725_트리의부모찾기 {

    public static int [] parent;
    public static ArrayList<Integer> [] al;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        parent=new int [N+1];
        al=new ArrayList[N+1];

        for(int i=0;i<N+1;++i){
            al[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;++i){
            int a=sc.nextInt();
            int b=sc.nextInt();
            al[a].add(b);
            al[b].add(a);
        }

        searchParent();

        for(int i=2;i<N+1;++i){
            System.out.println(parent[i]);
        }
    }

    public static void searchParent(){
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        parent[1]=1;

        while (!q.isEmpty()){
            int cur=q.poll();

            for (Integer next : al[cur]) {
                if(parent[next]==0){
                    q.offer(next);
                    parent[next]=cur;
                }
            }
        }
    }

}
