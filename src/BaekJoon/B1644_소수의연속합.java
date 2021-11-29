package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1644_소수의연속합 {

    static boolean prime[];
    static ArrayList<Integer> prime_numbers=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        prime=new boolean[N+1];
        prime[0]=prime[1]=true;

        for(int i=2;i*i<=N;++i){
            if(!prime[i]){
                for(int j=i*i;j<=N;j+=i) prime[j]=true;
            }
        }

        for(int i=1;i<=N;++i){
            if(!prime[i]) prime_numbers.add(i);
        }


        int answer=0;
        int sum=0;
        for(int i=0;i<prime_numbers.size();++i){
            sum=0;
            for(int j=i;j<prime_numbers.size();++j){
                sum+=prime_numbers.get(j);
                if(sum<N) continue;
                else if(sum==N) {
                    answer++;break;
                }
                else{
                    break;                }
            }
        }
        System.out.println(answer);

    }


}
