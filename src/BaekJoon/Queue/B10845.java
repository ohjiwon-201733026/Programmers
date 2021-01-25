package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());

		Queue<Integer> q=new LinkedList<>();
		StringBuilder sb=new StringBuilder();

		while(N-->0) {
			String [] a=br.readLine().split(" ");

			switch(a[0]){
				case "push":{
					int x=Integer.parseInt(a[1]);
					q.add(x);break;
				}
				case "pop":{
					if(q.size()==0) {
						sb.append(-1).append('\n'); break;
					}
					else {
						sb.append(q.poll()).append('\n');
						break;
					}
				}
				case "size":{
					sb.append(q.size()).append('\n');
					break;
				}
				case "empty":{
					sb.append(q.isEmpty()?1:0).append('\n');
					break;
				}
				case "front":{
					if(q.size()==0) {
						sb.append(-1).append('\n');
						break;
					}
					else{
						sb.append(q.peek()).append('\n');break;
					}
				}
				case "back":{
					if(q.size()==0) {
						sb.append(-1).append('\n');
						break;
					}
					else{
						Object[] arr=q.toArray();
						sb.append(arr[arr.length-1]).append('\n');break;
					}
				}
			}
		}


		System.out.println(sb);

	}

}
