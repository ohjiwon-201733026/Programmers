package BaekJoon;

import java.util.Scanner;

public class B2805_나무자르기 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [] arr=new int [n];

        int right=0;
        for(int i=0;i<n;++i) {
            arr[i]=sc.nextInt();
            right=Math.max(right,arr[i]);
        }
        int answer=0;
        int left=0;
        while (left<=right){
            System.out.println("-==");

            int mid=(left+right)/2;

            int sum=0;
            for(int i=0;i<n;++i) sum+=arr[i]-mid;

            if(sum>=m){
                left=mid+1;
                answer=mid;
            }
            else right=mid-1;
        }

        System.out.println(answer);

    }

}
