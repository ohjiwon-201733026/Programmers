package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B2529_부등호 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] c=new String[n];
        for(int i=0;i<n;++i) c[i]=sc.next();
        int [] arr=new int [10];
        for(int i=0;i<=9;++i) arr[i]=i;
        boolean [] visited=new boolean[10];
        int [] output=new int [n+1];
        int r=n+1;
        perm(arr,output,visited,0,10,r);
        ArrayList<String> answer=new ArrayList<>();




        for (String s : list) {
            int a=s.charAt(0)-'0';
            boolean flag=true;
            for(int i=1;i<s.length();++i){
                String op=c[i-1];
                int b=s.charAt(i)-'0';
                if(!calc(a,op,b)) {
                    flag=false;
                    break;
                }
                a=b;
            }
            if(flag) answer.add(s);

        }
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));


    }

    public static boolean calc(int a, String op, int b){
        if(op.equals("<")){
            if(a<b) return true;
            else return false;
        }
        else{
            if(a>b) return true;
            else return false;
        }
    }
    public static ArrayList<String> list=new ArrayList<>();
    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < r; ++i) {
                sb.append(output[i]);
            }
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }


    }
}
