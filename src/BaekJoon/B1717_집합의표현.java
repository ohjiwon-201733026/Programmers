package BaekJoon;

import java.util.Scanner;

public class B1717_집합의표현 {

    static int [] d;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        d=new int [n+1];

        for(int i=0;i<=n;++i) d[i]=i;

        while(m-->0){
            int op=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();

            if(op==0){
                union(a,b);
            }
            else{
                if(isSameParent(a,b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static int getParent(int a){
        if(a==d[a]) return d[a];
        return d[a]=getParent(d[a]);
    }

    static void union(int a, int b){
        a=getParent(a);
        b=getParent(b);
        if(a!=b) d[b]=a;
    }

    static boolean isSameParent(int a, int b){
        a=getParent(a);
        b=getParent(b);
        if(a==b) return true;
        else return false;
    }
}
