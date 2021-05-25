package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class B2141_우체국 {
	public static class Node implements Comparable<Node>{
		long x;
		long a;

		public Node(long x, long a) {
			this.x=x;
			this.a=a;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.x==o.x) {
				return (int)(this.a-o.a);
			}
			return (int)(this.x-o.x);
		}


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long num=0,result=0;
		Node [] arr=new Node[N];
		for(int i=0;i<N;++i) {
			long x=sc.nextLong();
			long a=sc.nextLong();
			arr[i]=new Node(x,a);
			num+=a;
		}

		Arrays.sort(arr);

		for(int i=0;i<N;++i) {
			result+=arr[i].a;
			if((num+1)/2<=result) {
				System.out.println(arr[i].x);
				return;
			}
		}


	}

}
