package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9470_Strahler순서 {

    static int [] inDegree;
    static ArrayList<Integer>[] list;
    static int [][] arr;
    static int m;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0){
            int k=sc.nextInt();
            m=sc.nextInt();
            int p=sc.nextInt();

            list=new ArrayList[m+1];
            inDegree=new int [m+1];
            visited=new boolean [m+1];
            arr=new int [m+1][2];
            for(int i=0;i<=m;++i) list[i]=new ArrayList<>();

            while (p-->0){
                int a=sc.nextInt();
                int b=sc.nextInt();
                list[a].add(b);
                inDegree[b]++;
            }

            bfs();
            int max=0;
            for (int[] a : arr) {
                max=Math.max(max,a[0]);
            }

            System.out.println(k+" "+max);

        }
    }

    static void bfs(){
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=m;++i){
            if(inDegree[i]==0) {
                arr[i][0]=1;
                q.add(i);
                visited[i]=true;
            }
        }

        while (!q.isEmpty()){
            int num=q.poll();

            for (Integer next : list[num]) {
                if(arr[next][0]==arr[num][0]){
                    arr[next][1]++;
                    inDegree[next]--;
                }
                else if(arr[next][0]<arr[num][0]){
                    arr[next][0]=arr[num][0];
                    arr[next][1]=1;
                    inDegree[next]--;
                }
                else if(arr[next][0]>arr[num][0]){
                    inDegree[next]--;
                }

                if(inDegree[next]==0){
                    if(arr[next][1]>=2) arr[next][0]++;
                    q.add(next);
                }
            }

        }
    }
}
