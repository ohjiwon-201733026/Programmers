package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1931_회의실배정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [][] arr=new int[N][2];
		for(int i=0;i<N;++i) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			arr[i][0]=start;
			arr[i][1]=end;
		}
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}

		});
		int cnt=0;
		int s=-1;
		for(int i=0;i<N;++i) {
			if(arr[i][0]>=s) {
				s=arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
