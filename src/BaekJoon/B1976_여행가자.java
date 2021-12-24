package BaekJoon;

import java.util.Scanner;

public class B1976_여행가자 {
    static int [] parent;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int [n];

        for(int i=0;i<n;++i) parent[i]=i;

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int a=sc.nextInt();
                if(a==1 && i<=j){
                    union(i,j);
                }
            }
        }
        int [] arr=new int [m];
        for(int i=0;i<m;++i){
            arr[i]=sc.nextInt()-1;
        }

        String answer="YES";
        int piv=find(arr[0]);
        for (int i : arr) {
            if(piv!=find(i)) answer="NO";
        }

        System.out.println(answer);
    }

    static int find(int x){
        if(x==parent[x]) return parent[x];

        return parent[x]=find(parent[x]);
    }

    static void union(int x,int y){
        x=find(x);
        y=find(y);

        if(x!=y){
            parent[y]=x;
        }
    }
}
