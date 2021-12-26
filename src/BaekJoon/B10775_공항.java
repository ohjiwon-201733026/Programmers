package BaekJoon;

import java.util.Scanner;

public class B10775_공항 {
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int G=sc.nextInt();
        int P=sc.nextInt();

        parent=new int [G+1];
        for(int i=1;i<=G;++i) parent[i]=i;

        int ans=0;
        for(int i=0;i<P;++i){
            int g=sc.nextInt();
            int emptyGate=find(g);

            if(emptyGate==0) break;

            ans++;
            union(emptyGate,emptyGate-1);
        }

        System.out.println(ans);
    }

    public static int find(int x){
        if (x==parent[x]) return x;

        return parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x!=y) parent[x]=y;
    }
}
