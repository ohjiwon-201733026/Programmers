package BaekJoon;

import java.util.Scanner;

public class B1654_랜선자르기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();

        long [] arr=new long [k];
        long max=0;

        for(int i=0;i<k;++i){
            arr[i]=sc.nextLong();
            max=Math.max(arr[i],max);
        }

        long start=1;
        long end=max+1;
        long answer=0;
        while(start<=end){
            long mid=(start+end)/2;
            int cnt=0;

            for (long i : arr) {
                cnt+=i/mid;
            }

            if(cnt>=n){
                start=mid+1;
                answer=Math.max(answer,mid);
            }
            else{
                end=mid-1;
            }

        }

        System.out.println(answer);
    }
}
