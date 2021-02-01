package BaekJoon.LinkedLists;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class B1168 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Scanner scan2=new Scanner(System.in);
	        int N=scan2.nextInt();
	        int K=scan2.nextInt();
	        StringBuilder SB = new StringBuilder();
	        Vector<Integer> v=new Vector<Integer>();

	        for(int i=1;i<=N ;i++) v.add(i);

	        int now=K-1; //현재 위치==now
	        while(true) {
	            SB.append(v.get(now));
	            v.remove(now);
	            if(v.size()==0) break;
	            SB.append(", ");
	            now+=K-1;
	            now%=v.size();
	        }
	        System.out.println("<"+SB+">");

	}

}
