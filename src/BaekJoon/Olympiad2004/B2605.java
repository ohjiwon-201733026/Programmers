// 줄세우기
package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B2605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		ArrayList<Integer> sort=new ArrayList<>();

		sort.add(1);
		for(int i=1;i<n;i++) {
			sort.add(i-arr[i],i+1);
		}
		Object[] answer=sort.toArray();
		for(int i=0;i<n;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
