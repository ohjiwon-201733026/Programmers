package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class D2_모험가길드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr=new int [N];
		for(int i=0;i<N;++i) {
			arr[i]=sc.nextInt();
		}

		Arrays.sort(arr);
		int result=0; // 그룹 수
		int count=0; // 현재그룹 사람 수
		for(int i=0;i<N;++i) {
			count+=1; // 나 추가
			if(count>=arr[i]) {
				result+=1;
				count=0;
			}
		}

		System.out.println(result);

	}

}
