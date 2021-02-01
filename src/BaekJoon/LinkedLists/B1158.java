package BaekJoon.LinkedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] a=br.readLine().split(" ");
		int N=Integer.parseInt(a[0]);
		int K= Integer.parseInt(a[1]);
		StringBuilder sb=new StringBuilder("<");
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;++i) {
			q.add(i);
		}

		while(!q.isEmpty()) {
			for(int i=1;i<=K;++i) {
				if(i==K) {
					if(q.size()==1) sb.append(q.poll()).append(">");
					else sb.append(q.poll()).append(", ");
				}
				else q.add(q.poll());
			}
		}

		System.out.println(sb);




	}

}
