// 색종이
package BaekJoon.Olympiad2005;

import java.util.Scanner;

public class B2590 {
	private static int [] arr;

	private static int solve(int size) {
		int ret=0;
		if(size==6) ret+=arr[6];
		if(size==5) {
			ret+=arr[5];
			arr[1]-=11*arr[5];
			if(arr[1]<0) arr[1]=0;
		}
		if(size==4) {
			ret+=arr[4];
			arr[2]-=5*arr[4];
			if(arr[2]<0) arr[1]+=4*arr[2];
			if(arr[2]<0) arr[2]=0;
			if(arr[1]<0) arr[1]=0;
		}

		if(size==3) {
			ret+=arr[3]/4;
			arr[3]%=4;
			if(arr[3]>0) {
				ret+=1;
				if(arr[3]==3) {
					if(arr[2]>0) {
						arr[2]-=1;
						arr[1]-=5;
					}
					else arr[1]-=9;
				}
				else if(arr[3]==2) {
					if(arr[2]>0) {
						arr[2]-=3;
						arr[1]-=6;
					}
					else arr[1]-=18;
				}
				else if(arr[3]==1) {
					if(arr[2]>0) {
						arr[2]-=5;
						arr[1]-=7;
					}
					else arr[1]-=27;
				}
				if(arr[1]<0) arr[1]=0;
				if(arr[2]<0) arr[2]=0;
			}
		}

		if(size==2) {
			ret+=(arr[2]/9);
			arr[2]%=9;
			if(arr[2]>0) {
				ret+=1;
				arr[1]-=(9-arr[2])*4;
				if(arr[1]<0) arr[1]=0;
			}
		}
		if(size==1) {
			ret+=arr[1]/36;
			if(arr[1]%36>0) ret+=1;
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		arr=new int[7];
		int ans=0;

		for(int i=1;i<=6;i++)
			arr[i]=sc.nextInt();

		for(int i=6;i>=1;i--) if(arr[i]>0) ans+=solve(i);

		System.out.println(ans);


	}

}
