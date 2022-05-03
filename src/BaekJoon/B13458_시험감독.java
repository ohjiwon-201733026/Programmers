package BaekJoon;

import java.util.Scanner;

public class B13458_시험감독 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        int b=sc.nextInt();
        int c=sc.nextInt();

        long cnt=0;
        for(int i=0;i<n;++i){
            arr[i]-=b; // 총감독
            cnt+=1;
            if(arr[i]<=0) continue;
            long num=arr[i]%c==0?arr[i]/c:(arr[i]/c)+1;
            cnt+=num;
        }

        System.out.println(cnt);
    }
}
