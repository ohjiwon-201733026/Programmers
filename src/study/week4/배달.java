package study.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=6;
		int [][] road= {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K=3;
		int res=solution(N,road,K);
		System.out.println(res);
	}

	public static class Node implements Comparable<Node>{
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end=end;
			this.weight=weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}

	}


	private static int solution(int n, int[][] road, int k) {
		// TODO Auto-generated method stub
		boolean []check=new boolean [n+1]; // 방문 체크
		int [] d=new int [n+1];
		List<Node> [] list=new ArrayList[n+1];
		Arrays.fill(d,Integer.MAX_VALUE);

		for(int i=1;i<=n;++i) {
			list[i]=new ArrayList<Node>();
		}

		for(int i=0;i<road.length;++i) {
			int [] a=road[i];
			list[a[0]].add(new Node(a[1],a[2]));
			list[a[1]].add(new Node(a[0],a[2]));
		}

		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(new Node(1,0));
		d[1]=0;

		while(!pq.isEmpty()) {
			Node curNode=pq.poll();
			int cur=curNode.end;

			if(check[cur]==true) continue;
			check[cur]=true;

			for(Node node:list[cur]) {
				if(!check[node.end]&&d[node.end]>d[cur]+node.weight) {
					d[node.end]=d[cur]+node.weight;
					pq.add(new Node(node.end,d[node.end]));
				}
			}
		}
		int cnt=0;
		for(int i=1;i<d.length;++i) {
			if(d[i]<=k) cnt++;
		}

		return cnt;


	}

}
