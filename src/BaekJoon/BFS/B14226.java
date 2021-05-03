// 이모티콘
package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {
	public static class Node{
		int len; // 화면 이모티콘 길이
		int buf; // 클립보드의 이모티콘 길이
		int cnt; // 연산 초

		Node(int len,int buf, int cnt){
			this.len=len;
			this.buf=buf;
			this.cnt=cnt;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int S=sc.nextInt();

		boolean [][] visited=new boolean[2002][2002]; //???
		Queue<Node> q=new LinkedList<>();

		visited[1][0]=true;
		q.add(new Node(1,0,0));

		while(!q.isEmpty()) {
			Node cur=q.poll();

			if(cur.len==S) {
				System.out.println(cur.cnt);
				return;
			}

			// copy
			q.add(new Node(cur.len,cur.len,cur.cnt+1));

			// paste
			if(!visited[cur.len+cur.buf][cur.buf] && cur.buf!=0 && cur.len+cur.buf!=0)
				q.add(new Node(cur.len+cur.buf,0,cur.cnt+1));

			//delete
			if(cur.len>0 && !visited[cur.len-1][cur.buf]&& cur.len-1<=1000) {
				visited[cur.len-1][cur.buf]=true;
				q.add(new Node(cur.len-1,cur.buf,cur.cnt+1));
			}
		}

	}


}
