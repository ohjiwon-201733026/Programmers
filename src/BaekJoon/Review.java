package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] a=new int[N];
		int [] dp=new int[N];
		int sum=0;
		for(int i=0;i<N;++i) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<N;++i) {
			if(i==0) dp[i]=a[i];
			else dp[i]=dp[i-1]+a[i];
		}

		for(int i=0;i<N;++i) {
			sum+=dp[i];
		}
		System.out.println(sum);
	}
}
