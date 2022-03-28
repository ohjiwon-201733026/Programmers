package BaekJoon;

import java.util.Scanner;

public class B14888_연산자끼워넣기 {

    public static int [] A;
    public static long min,max;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        A=new int [n];
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;

        for(int i=0;i<n;++i) A[i]=sc.nextInt();

        int [] op=new int [4];
        for(int i=0;i<4;++i) op[i]=sc.nextInt();

        recur(1,A[0],op);

        System.out.println(max);
        System.out.println(min);

    }

    public static void recur(int depth,long sum,int [] op){
        if(depth==A.length){
            max=Math.max(sum,max);
            min=Math.min(sum,min);
            return;
        }

        for(int i=0;i<4;++i){
            if(op[i]>0){
                op[i]-=1;
                if(i==0) recur(depth+1,sum+A[depth],op);
                if(i==1) recur(depth+1,sum-A[depth],op);
                if(i==2) recur(depth+1,sum*A[depth],op);
                if(i==3) recur(depth+1,sum/A[depth],op);
                op[i]+=1;
            }
        }
    }
}
