package BaekJoon;

import java.util.Scanner;

public class B11401_이항계수 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();



        int min=N-K<K?N-K:K;
        int max=N-K<K?K:N-K;

        long a=factorial(N,max+1);
        long b=factorial(min,1);

        System.out.println((a/b)%1000000007);


    }

    static long factorial(int a, int b){
        long sum=1;
        if(a==b) return 1;

        for(int i=b;i<=a;++i){
            sum*=i;
        }

        return sum;
    }
}
