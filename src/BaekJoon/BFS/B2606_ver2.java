// 바이러스 문제  union find로 풀기
package BaekJoon.BFS;
import java.util.Scanner;

public class B2606_ver2 {
	public static int [] parent;
	public static int count=0;

	public static int getParent(int i) {
		if(parent[i]==i) return parent[i];
		return parent[i]=getParent(parent[i]);
	}

	public static void unionParent(int i, int j) {
		i=getParent(i);
		j=getParent(j);

		if(i<j) parent[j]=i;
		else parent[i]=j;
	}

	public static boolean find(int i, int j) {
		i=getParent(i);
		j=getParent(j);

		if(i==j) return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();

		parent=new int[N+1];

		for(int i=1;i<=N;++i) {
			parent[i]=i;
		}

		for(int i=0;i<K;++i) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			unionParent(x,y);
		}

		for(int i=2;i<=N;++i) {
			if(getParent(i)==getParent(1)) ++count;
		}
		System.out.println(count);
	}

}
