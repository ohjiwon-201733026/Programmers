// 숨바꼭질 2
package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851 {

	static int min;
	static int cnt;

	static class Pair{
		int a;
		int time;

		Pair(int a, int time){
			this.a=a;
			this.time=time;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();

		min=Integer.MAX_VALUE;
		cnt=1;

		//N이 K보다 큰 경우에는 -1씩 N-K만큼 뒤로 가야함
		// 이 방법 한가지 뿐이다
		if(N>K) {
			System.out.println(N-K);
			System.out.println(1);
		}else {
			bfs(N,K);
			System.out.println(min);
			System.out.println(cnt);;
		}

	}

	private static void bfs(int n, int k) {
		// TODO Auto-generated method stub
		Queue<Pair> q=new LinkedList<>();
		boolean [] visit=new boolean[100001];
		int time=0;

		// 초기설정
		visit[n]=true;
		q.offer(new Pair(n,time));

		// q가 빌 떄 까지 반복
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int aa=p.a;
			int tt=p.time;
			visit[aa]=true;

			if(aa==k) {
				if(min>tt)min=tt;
				else if(min==tt) cnt++;
				continue;
			}

			// 이동할 수 있는 세가지 위치 모두 확인
			int dx1=aa-1;
			int dx2=aa+1;
			int dx3=2*aa;

			// 이동할 수 있는 경우 큐에 넣고 방문처리
			if(dx1>=0 && !visit[dx1]) q.offer(new Pair(dx1,tt+1));
			if(dx2>=0 && !visit[dx2]) q.offer(new Pair(dx2,tt+1));
			if(dx3>=0 && !visit[dx3]) q.offer(new Pair(dx3,tt+1));
		}

	}

}
