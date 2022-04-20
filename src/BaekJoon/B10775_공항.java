package BaekJoon;

import java.util.Scanner;

public class B10775_공항 {
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int g=sc.nextInt(); // 게이트 수
        int p=sc.nextInt(); // 비행기 수

        parent=new int [g+1];
        for(int i=0;i<=g;++i) parent[i]=i;
        int answer=0;

        while (p-->0){
            int gate=sc.nextInt();
            int emptyGate=find(gate);

            if(emptyGate==0) break;

            answer++;
            union(emptyGate,emptyGate-1);
        }

        System.out.println(answer);
    }

    static int find(int x){
        if(x==parent[x]) return x;

        return parent[x]=find(parent[x]);
    }

    static void union(int x, int y){
        x=find(x);
        y=find(y);

        if(x!=y) parent[x]=y;
    }
}
