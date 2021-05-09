package Programmers.Kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kakao20210508_2 {
	public static int [][] visit;
	public static char [][] arr;
	public static int [] result;
	public static int [] dx= {0,-1,0,1};
	public static int [] dy= {-1,0,1,0};
	public static boolean flag=true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=5;
		arr=new char[5][5]; // 입력 받을 배열
		result=new int [5]; // 결과 담을 배열
		String [] tmp= {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"};
//		while(N-->0) {
			flag=true;
			for(int i=0;i<5;++i) { // 입력받기
				String s=tmp[i];
				for(int j=0;j<5;++j) {
					arr[i][j]=s.charAt(j);
				}
			}

			for(int i=0;i<5;++i) { // 'P'찾기
				for(int j=0;j<5;++j) {
					if(arr[i][j]=='P') {
						visit=new int [5][5];
						bfs(i,j);
					}
				}
			}
			System.out.println(flag);
//		}

	}

	private static void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				System.out.print(visit[i][j]);
			}
			System.out.println();
		}
		System.out.println(flag);
		System.out.println();

	}

	public static class Node{
		int x;
		int y;

		Node (int x, int y){
			this.x=x;
			this.y=y;
		}
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(i,j));
		visit[i][j]=1;
		loop1:
		while(!q.isEmpty()) {
			Node p=q.poll();
			for(int k=0;k<4;++k) {
				int x=p.x+dx[k];
				int y=p.y+dy[k];
				if(0<=x && x<5 && 0<=y && y<5) { // 범위 안에 있고
					if(arr[x][y]=='O') { // 빈칸 만났을 경우
						visit[x][y]=visit[p.x][p.y]+1;
						q.add(new Node(x,y));
					}
					if(arr[x][y]=='X') { // 파티션인 경우 4
						visit[x][y]=4;
						q.add(new Node(x,y));
					}
					if(arr[x][y]=='P') { // 다른 응시자 있을 경우
						if(visit[p.x][p.y]+1<5) { // 3칸 띄어지지 않는 경우
							flag=false; // false
							q.add(new Node(x,y));
							break loop1;
					}
				}

			}
			}
		}

	}

}
