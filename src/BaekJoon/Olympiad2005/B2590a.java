// 색종이 간단한 ver
package BaekJoon.Olympiad2005;

import java.util.Scanner;

public class B2590a {
	private static int [] d;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		d=new int[7];
		int ans=0;

		for(int i=1;i<=6;i++)
			d[i]=sc.nextInt();

//		for(int i=6;i>=1;i--) if(arr[i]>0) ans+=solve(i);
		int five=d[5]*11; // 5*5는 1*1짜리 사용 (6*6-5*5=1*11) //5*5들어있는 판넬이 1*1몇칸이 남았는지
		int four=d[4]*5; // 4*4는 2*2먼저 사용하고 남은 2*2들을 1*1로 변환 ( 6*6-4*4=2*2*5 ) //4*4들어있는 판넬이 2*2가 몇개 들어갈 수 있는지

		int panel=d[6]+d[5]+d[4];

		d[1]-=five; // 5*5판넬에 남은것들에 1*1을 넣고 남아있는 1*1의 갯수
		d[2]-=four; // 4*4판넬에 남은것들에 2*2을 넣고 남아있는 1*1의 갯수

		if(d[1]>0 && d[2]<0) d[1]+=d[2]*4; // 2*2 다쓰고 1*1만 남아있다면 1*1로

		panel+=d[3]/4; // 3*3은 한 판넬에 최대 4개까지 들어갈 수 있음
		int three=d[3]%4;
		if(three>0) {
			panel++;
			d[2]=d[2]>0?d[2]:0; //Math.max(d[2],0)
			if(d[2]>=0) {
				d[2]-=5-(three-1)*2; //?
				d[1]+=d[2]*4;
				d[1]-=8-three; //?
			}
		}

		if(d[2]>0) {
			panel+=d[2]/9;
			int two=d[2]%9;
			if(two>0) {
				panel++;
				int ableOne=-4*two+36;
				d[1]-=ableOne;
			}

		}

		while(d[1]>0) {
			panel++;
			d[1]-=36;
		}

		System.out.println(panel);
	}



}
