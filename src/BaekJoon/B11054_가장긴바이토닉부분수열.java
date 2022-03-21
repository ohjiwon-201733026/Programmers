package BaekJoon;

import java.util.Scanner;

public class B11054_가장긴바이토닉부분수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int [n];
        int [] min=new int [n]; // 반대
        int [] max=new int [n]; //

        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<i;++j){
                if(arr[i]>arr[j]){
                    max[i]=Math.max(max[i],max[j]);
                }
            }
            max[i]++;
        }

        for(int i=n-1;i>=0;--i){
            for(int j=n-1;j>i;--j){
                if(arr[i]>arr[j]){
                    min[i]=Math.max(min[i],min[j]);
                }
            }
            min[i]++;
        }
        int answer=0;
        for(int i=0;i<n;++i){
            answer=Math.max(answer,max[i]+min[i]-1);
        }
        System.out.println(answer);
    }
}
