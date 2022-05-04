package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1043_거짓말 {
   static int [] parent;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int[n+1];

        int known_num=sc.nextInt();
        boolean [] people_known=new boolean [n+1];
        for(int i=0;i<known_num;++i) people_known[sc.nextInt()]=true;

        ArrayList<Integer> [] parties=new ArrayList[m+1];
        for(int i=0;i<=n;++i) parent[i]=i;
        for(int i=1;i<=m;++i){
            parties[i]=new ArrayList<>();

            int num=sc.nextInt();
            for(int j=0;j<num;++j){
                int a=sc.nextInt();
                if(j==0) parties[i].add(a);
                else{
                    int b=parties[i].get(j-1);
                    if(find(a)!=find(b)) union(b,a);

                    parties[i].add(a);
                }
            }


        }

        boolean [] visited=new boolean[n+1];
        for(int i=0;i<people_known.length;++i){
            int root=0;
            if(people_known[i]) root=find(i);
            for(int j=1;j<=n;++j){
                if(find(j)==root && !visited[j]){
                    visited[j]=true;
                    people_known[j]=true;
                }
            }
        }
        int answer=0;
        for (int i=1;i<=m;++i) {
            ArrayList<Integer> party=parties[i];
            boolean flag=true;
            for (Integer person : party) {
                if(visited[person]){
                    flag=false;
                    break;
                }
            }

            if(flag) answer++;

        }
        System.out.println(answer);


    }


    static int find(int x){
        if(x==parent[x]) return x;

        return parent[x]=find(parent[x]);
    }

    static void union(int a, int b){
        a=find(a);
        b=find(b);

        if(a!=b){
            parent[b]=a;
        }
    }
}
