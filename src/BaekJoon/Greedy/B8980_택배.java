package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B8980_택배 {
	public static class Box implements Comparable<Box>{
		int start;
		int end;
		int weight;

		Box(int start, int end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}

		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			if(this.end==o.end) {
				return this.start-o.start;
			}
			return this.end-o.end;
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); // 마을 수
		int C=sc.nextInt(); // 트럭 용량
		int M=sc.nextInt(); // 박스 수

		Box [] del=new Box[M+1];
		for(int i=1;i<=M;++i) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			int weight=sc.nextInt();

			del[i]=new Box(start,end,weight);
		}
		Arrays.sort(del,1,M+1);

		int [] weight=new int [N+1];
		for(int i=1;i<N;++i) {
			weight[i]=C;
		}

		int ans=0;
		for(int i=1;i<=M;++i) {
			Box b=del[i];

			int maxBoxNum=Integer.MAX_VALUE;
			for(int j=b.start;j<b.end;++j) {
				maxBoxNum=Math.min(maxBoxNum, weight[j]);
			}

			if(maxBoxNum>=b.weight) {
				for(int j=b.start;j<b.end;++j) {
					weight[j]-=b.weight;
				}
				ans+=b.weight;
			}
			else {
				for(int j=b.start;j<b.end;++j) {
					weight[j]-=maxBoxNum;
				}
				ans+=maxBoxNum;
			}
		}

		System.out.println(ans);

	}

}
