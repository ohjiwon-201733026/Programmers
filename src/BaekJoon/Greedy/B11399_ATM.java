package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B11399_ATM {

	public static int [] arr;
	public static int [] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N];
		dp=new int [N];

		for(int i=0;i<N;++i) arr[i]=sc.nextInt();

		Arrays.sort(arr);

		for(int i=0;i<N;++i) dp(i);


		int sum=0;
		for(int i=0;i<N;++i) sum+=dp[i];
		System.out.println(sum);
	}

	public static void dp(int i) {
		if(i==0) {
			dp[i]=arr[i];
			return;
		}

		dp[i]=dp[i-1]+arr[i];
	}

}
