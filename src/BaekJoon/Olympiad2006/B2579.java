//계단 오르기
package BaekJoon.Olympiad2006;

import java.util.Scanner;

public class B2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] score=new int [n+1];
		int [] dp=new int [n+1];
		for(int i=1;i<=n;i++) {
			score[i]=sc.nextInt();
		}

		dp[1]=score[1];
		dp[2]=Math.max(dp[1]+score[2], score[2]);

		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-3]+score[i-1]+score[i], dp[i-2]+score[i]);
		}

		System.out.println(dp[n]);


//	    n-3 | n-2 | n-1 |  n
//   ------------------------
//		 o  |  x  |  o  |  o   --> 1칸 jump로 n에 도착  dp[n]=dp[n-3]+score[n-1]+score[n]
// 	  o 또는 x|  o  |  x  |  o   --> 2칸 jump로 n에 도착 dp[n]=dp[n-2]+score[n]



	}

}
