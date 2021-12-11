package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1422_숫자의신 {
    private static ArrayList<int []> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        long [] arr=new long[k];

        for(int i=0;i<k;++i) arr[i]=sc.nextLong();

        int [] output=new int [k];
        int [] t=new int [k];
        for (int i=0;i<k;i++) {
            t[i]=i;
        }

        perm(t,output,0,k,n);
        System.out.println(list.size());

        for (int[] a : list) {
            long [] tmp=new long [n];
            int x=0;
            for (int i=0;i<a.length;++i) {
                int y=a[i];
                for(int l=0;l<y;++l){
                    tmp[x]=arr[i];
                    x++;
                }
            }
            int r= tmp.length;
            boolean [] visited=new boolean[r];
            perm2(tmp,new long [r],visited,0,r,r);
        }

        System.out.println(answer);


    }
    private static long answer=0;
    private static void perm2(long[] arr, long[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < r; ++i) {
                sb.append(output[i]);
            }
            answer=Math.max(answer,Integer.parseInt(sb.toString()));
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]==true){
                visited[i]=true;
                output[depth]=arr[i];
                perm2(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }


    }

    private static void perm(int[] arr, int[] output,  int depth, int n, int r) {
        if(depth==r){
            int [] tmp=new int [output.length];
            for(int i=0;i<output.length;++i){
//                if(output[i]==0) return;
                System.out.print(output[i]+" ");
                tmp[i]=output[i];
            }
            System.out.println();
            list.add(tmp);
            return;
        }

        for(int i=0;i<n;++i){
            output[arr[i]]++;
            perm(arr,output,depth+1,n,r);
            output[arr[i]]--;
        }
    }
}
