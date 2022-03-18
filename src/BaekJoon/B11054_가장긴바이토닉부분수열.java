package BaekJoon;

import java.util.Scanner;

public class B11054_가장긴바이토닉부분수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int [n];
        int [] max=new int [n];
        int [] min=new int [n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n;++i){
            max[i]=1;
            for(int j=0;j<i;++j){
                if(arr[j]<arr[i]){
                    max[i]=Math.max(max[i],max[j]+1);
                }
            }
        }

        for(int i=n-1;i>=0;--i){
            min[i]=1;
            int a=0;
            for(int j=n-1;j>=i;--j){
                if(arr[j]<arr[i]){
                    min[i]=Math.max(min[i],min[j]+1);
                }
            }
            min[i]+=a;
        }

        int answer=0;
        for(int i=0;i<n;++i){
            answer=Math.max(answer,max[i]+min[i]-1);
        }
        System.out.println(answer);

    }
}
