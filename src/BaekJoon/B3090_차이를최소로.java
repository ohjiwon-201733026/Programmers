package BaekJoon;

import java.util.Scanner;

public class B3090_차이를최소로 {

    static int N,T;
    static long [] A;
    static long [] copyA;
    static long [] result;
    public static void main(String[] args) {
        final int max=100000+1;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        T= sc.nextInt();
        A=new long [max];
        copyA=new long [max];
        result=new long [max];

        for(int i=0;i<N;++i){
            A[i]=sc.nextInt();
        }

        long low=0;
        long high=1000000000;
        while (low<=high){
            long mid=(low+high)/2;
            if(possible(mid)){
                for(int i=0;i<N;++i){
                    result[i]=copyA[i];
                }
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }

        for(int i=0;i<N;++i){
            System.out.print(result[i]+" ");
        }
    }

    static boolean possible(long diff){
        for(int i=0;i<N;++i){
            copyA[i]=A[i];
        }
        int cnt=0;
        for(int i=0;i<N;++i){
            if(copyA[i+1]-copyA[i]>diff){
                cnt+=copyA[i+1]-(copyA[i]+diff);
                copyA[i+1]=copyA[i]+diff;
            }
        }

        for(int i=N-1;i>0;--i){
            if(copyA[i-1]-copyA[i]>diff){
                cnt+=copyA[i-1]-(copyA[i]+diff);
                copyA[i-1]=copyA[i]+diff;
            }
        }

        if(cnt<=T) return true;
        else return false;
    }
}
