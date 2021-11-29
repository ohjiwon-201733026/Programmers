package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B6588_골드바흐의추측 {
    public static final int MAX=1000000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        boolean [] prime=new boolean [MAX+1];

        prime[0]=prime[1]=true;
        for(int i=2;i*i<=MAX;++i){
            if(!prime[i]){
                for(int j=i*i;j<=MAX;j+=i) prime[j]=true;
            }
        }




        while(true){
            int a=-1,b=-1;
            int N=sc.nextInt();

            if(N==0) break;

            for(int i=2;i<=N/2;++i){
                if(!prime[i] && !prime[N-i]){
                    a=i<N-i?i:N-i;
                    b=N-a;
                    break;
                }
            }

            if(a==-1) System.out.println("Goldbach's conjecture is wrong.");
            else{
                System.out.println(N+" = "+Math.min(a,b)+" + "+Math.max(a,b));
            }
        }
    }
}
