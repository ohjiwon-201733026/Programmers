package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1043_거짓말 {

    static int [] parent;
    static int knownMin;
    static ArrayList<Integer> [] party;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        parent=new int [n+1];
        party=new ArrayList[m];
        for(int i=0;i<=n;++i) parent[i]=i;

        int t=sc.nextInt();
        if(t==0) {
            System.out.println(m);
            return;
        }
        int [] known=new int [t];
        for(int i=0;i<known.length;++i) known[i]=sc.nextInt();

        Arrays.sort(known);
        knownMin=known[0];

        for(int i=1;i<t;++i){
            union(known[i-1],known[i]);
        }

        for(int i=0;i<m;++i){
            int k=sc.nextInt();

            party[i]=new ArrayList<>();
            int pre=0;
            for(int j=0;j<k;++j) {
                int a=sc.nextInt();
                if (j == 0) pre = a;
                else {
                    int b = a;
                    union(pre, b);

                }

                party[i].add(a);
            }

        }

        int cnt=0;
        knownMin=parent[known[0]];
        for (ArrayList<Integer> arr : party) {

            boolean flag=true;

            for (Integer num : arr) {
                if(parent[num]==knownMin){
                    flag=false;
                    break;
                }
            }

            if(flag) cnt++;
        }

        System.out.println(cnt);


    }

    public static int getParent(int x){
        if(x==parent[x]) return x;

        return parent[x]=getParent(parent[x]);
    }

    public static void union(int a, int b){
        a=getParent(a);
        b=getParent(b);

        if(a<=b){
            parent[b]=a;
        }
        else{
            parent[a]=b;
        }
    }
}
