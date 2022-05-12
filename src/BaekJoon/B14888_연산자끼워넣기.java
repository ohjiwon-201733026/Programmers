package BaekJoon;

import java.util.Scanner;

public class B14888_연산자끼워넣기 {

    static int [] A;
    static int n;
    static int min,max;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        A=new int [n];
        for(int i=0;i<n;++i) A[i]=sc.nextInt();

        int [] op=new int [4];
        for(int i=0;i<4;++i) op[i]=sc.nextInt();
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;

        backTracking(A[0],op,1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void backTracking(int sum, int [] op,int depth){
        if(depth==n){
            min=Math.min(min,sum);
            max=Math.max(max,sum);
            return;
        }

        if(op[0]>0) {
            op[0]-=1;
            backTracking(sum+A[depth],op,depth+1);
            op[0]+=1;
        }
        if(op[1]>0) {
            op[1]-=1;
            backTracking(sum-A[depth],op,depth+1);
            op[1]+=1;
        }
        if(op[2]>0) {
            op[2]-=1;
            backTracking(sum*A[depth],op,depth+1);
            op[2]+=1;
        }
        if(op[3]>0) {
            op[3]-=1;
            backTracking(sum/A[depth],op,depth+1);
            op[3]+=1;
        }

    }
}
