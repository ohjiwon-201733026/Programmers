package BaekJoon;

import java.util.Scanner;

public class B2805_나무자르기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        long M=sc.nextLong();

        Long [] tree=new Long[N];
        long max=0;
        for(int i=0;i<N;++i){
            tree[i]=sc.nextLong();
            max=Math.max(max,tree[i]);
        }

        long left=0;
        long right=max;
        long ans=0;
        while(left<=right){
            long mid=(left+right)/2;
            long sum=0;
            for (Long len : tree) {
                sum+=(len-mid)<0?0:len-mid;
            }

            if(M<=sum){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }

        System.out.println(ans);

    }
}
