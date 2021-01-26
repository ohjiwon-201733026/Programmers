package BaekJoon.Strings;

import java.util.Scanner;

public class B10820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int so,dae,num,gong;


		while(sc.hasNext()) {
			so=0;dae=0;num=0;gong=0;
			String s=sc.nextLine();
			for(int i=0;i<s.length();++i) {
				char c=s.charAt(i);
				if('a'<=c&&c<='z') ++so;
				if('A'<=c&&c<='Z') ++dae;
				if(0<=c-'0'&&c-'0'<=9) ++num;
				if(c==' ') gong++;
			}

			System.out.println(so+" "+dae+" "+num+" "+gong);
		}

	}

}
