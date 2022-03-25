package BaekJoon;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class B15663_N과M9 {

    static int n,m;
    static int [] arr;
    static LinkedHashSet<String> set;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int [n];
        set=new LinkedHashSet<>();

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        Arrays.sort(arr);

        recur(new boolean[n],new int [m],0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void recur(boolean [] visited, int [] output, int depth){
        if(depth==m){
            StringBuilder sb=new StringBuilder();
            for (int i : output) {
                sb.append(i).append(' ');
            }

            set.add(sb.toString());
            return;
        }

        for(int i=0;i<arr.length;++i){
            if(!visited[i]){
                output[depth]=arr[i];
                visited[i]=true;
                recur(visited,output,depth+1);
                visited[i]=false;
            }
        }
    }


}
