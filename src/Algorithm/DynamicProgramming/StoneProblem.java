// 돌 놓기 문제
package Algorithm.DynamicProgramming;

public class StoneProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr= {{6,7,12,-5,5,3,11,3},
					{-8,10,14,9,7,13,8,5},
					{11,12,7,4,8,-2,9,4}};

		int [][] w=new int [4][8];

		for(int i=0;i<8;i++) {
			w[0][i]=arr[0][i];
			w[1][i]=arr[1][i];
			w[2][i]=arr[2][i];
			w[3][i]=arr[0][i]+arr[2][i];
		}
		int [][] peb=new int [4][8];
		for(int i=0;i<3;i++) peb[i][0]=w[i][0];
		peb[3][0]=w[0][0]+w[2][0];

		for(int i=1;i<8;i++) {
			for(int p=0;p<4;p++) {
				if(p==0) {
					peb[p][i]=Math.max(peb[1][i-1], peb[2][i-1])+w[p][i];
				}
				else if(p==1) {
					peb[p][i]=Math.max(Math.max(peb[0][i-1], peb[2][i-1]),peb[3][i-1])+w[p][i];
				}
				else if(p==2) {
					peb[p][i]=Math.max(peb[0][i-1], peb[1][i-1])+w[p][i];
				}
				else if(p==3) {
					peb[p][i]=peb[1][i-1]+w[p][i];
				}

			}
		}
		System.out.println(peb[3][7]);

	}

}
