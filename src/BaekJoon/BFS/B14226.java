// 이모티콘
package BaekJoon.BFS;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {
	public static int S;
	public static boolean [][] visit;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		S=sc.nextInt();
		visit=new boolean[2001][2001];

		bfs(1);

	}

	private static void bfs(int n) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		visit[n][0]=true;
		q.add(new Node(n,0,0));

		while(!q.isEmpty()) {
			Node p=q.poll();
			if(p.screen==S) {
				System.out.println(p.cnt);
				return;
			}

			// 1. 화면 이모티콘 모두 복사, 클립보드 저장
			if(!visit[p.screen][p.screen]) {
				q.add(new Node(p.screen,p.screen,p.cnt+1));
				visit[p.screen][p.screen]=true;
			}

			// 2. 클립보드에 있는 모든 이모티콘 화면 붙이기
			if(!visit[p.screen+p.clipboard][p.clipboard] && p.clipboard!=0 && p.screen+p.clipboard<=1000) {
				q.add(new Node(p.screen+p.clipboard,p.clipboard,p.cnt+1));
				visit[p.screen+p.clipboard][p.clipboard]=true;
			}

			// 3. 화면에 하나 삭제
			if(p.screen>0&&!visit[p.screen-1][p.clipboard]&& p.screen-1<=1000) {
				q.add(new Node(p.screen-1,p.clipboard,p.cnt+1));
				visit[p.screen-1][p.clipboard]=true;
			}
			}
		}


	public static class Node{
		int screen;
		int clipboard;
		int cnt;

		public Node(int screen,int clipboard, int cnt) {
			this.screen=screen;
			this.clipboard=clipboard;
			this.cnt=cnt;
		}
	}


}
