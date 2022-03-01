package BaekJoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class B1043_거짓말 {

    static int [] parent;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean [] known_true=new boolean[n+1];
        party=new ArrayList[n+1];
        parent=new int [n+1];
        int t=sc.nextInt();
        while (t-->0){
            int a=sc.nextInt();
            known_true[a]=true;
        }
        for(int i=0;i<parent.length;++i) {
            parent[i]=i;
            party[i]=new ArrayList<>();
        }

        for(int i=0;i<m;++i){
            String [] a=sc.nextLine().split(" ");
            for (String s : a) {
                System.out.println(s);
            }
            int y=0;
            for(int j=1;j<a.length;++j){
                int x=Integer.parseInt(a[j]);
                party[i].add(x);
                if(j==1) {
                    y=x;
                    continue;
                }
                else {
                    union(getParent(x), getParent(y));
                    y=x;
                }

            }
        }

        for (int i : parent) {
            System.out.println(i);
        }




    }

    public static int getParent(int a){
        if(a==parent[a]) return a;
        return parent[a]=getParent(parent[a]);
    }

    public static void union(int a, int b){
        System.out.println(a+" "+b);
        a=getParent(a);
        b=getParent(b);

        if(a<b){
            parent[b]=a;
        }
        else parent[a]=b;
    }
}
