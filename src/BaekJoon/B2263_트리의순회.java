package BaekJoon;

import java.util.Scanner;

public class B2263_트리의순회 {

    static int n;
    static int [] in,post,pre;
    static int idx=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        in=new int [n];
        post=new int [n];
        pre=new int [n];

        for(int i=0;i<n;++i){
            in[i]=sc.nextInt();
        }
        for(int i=0;i<n;++i){
            post[i]=sc.nextInt();
        }

        dfs(0,n-1,0,n-1);

        for (int i : pre) {
            System.out.print(i+" ");
        }
    }

    public static void dfs(int is,int ie, int ps, int pe){
        if(is<=ie && ps<=pe){

            pre[idx++]=post[pe];

            int pos=is;
            for(int i=is;i<=ie;++i){
                if(in[i]==post[pe]){
                    pos=i;
                    break;
                }
            }

            dfs(is,pos-1,ps,ps+pos-is-1);
            dfs(pos+1,ie,ps+pos-is,pe-1);
        }
    }
}
