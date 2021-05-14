package BaekJoon.Greedy;

import java.util.Scanner;

public class B1439_뒤집기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		boolean [] arr=new boolean[s.length()];

		for(int i=0;i<s.length();++i) {
			if(s.charAt(i)=='0') arr[i]=false; // 0은 false
			else arr[i]=true; // 1은 true
		}


		int falseNum=0; // 0 개수
		int trueNum=0; //1 개수
		boolean flag=arr[0]; // 이전
		if(flag==true) trueNum++; // 해당  카운트
		else falseNum++;

		for(int i=1;i<arr.length;++i) {
			if(flag==arr[i]) continue; // 연속인 경우
			else { // 바뀌는 시점  // 1. 해당 카운트+1 // 2.flag 값 바꾸기
				if(arr[i]==true) trueNum++;
				else falseNum++;
				flag=arr[i];
			}
		}

		System.out.println(trueNum<falseNum?trueNum:falseNum);

	}

}
