import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			dp = new int[n + 1][m + 1];
			for(int i=0;i<=m;++i) dp[1][i]=i;
			for (int i = 2; i <= n; ++i) {
				for (int j = i; j <= m; ++j) {
					if (i == j) dp[i][j] = 1;
					else dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				}
			}

			System.out.println(dp[n][m]);
		}
	}
}
