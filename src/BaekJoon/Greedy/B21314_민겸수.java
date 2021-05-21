package BaekJoon.Greedy;

import java.util.Scanner;

public class B21314_민겸수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		StringBuilder sb=new StringBuilder();
		int m=0;
		// 최대값 구하기
		boolean flag=false;
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if(c=='K') flag=true;
		}
		if(flag==false) { // 전체 다  M인 경우
			sb.append("1");
			for(int i=0;i<s.length()-1;++i) sb.append("0");
		}
		else {
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if(c=='K') {
				sb.append("5");
				for(int j=0;j<m;++j) sb.append("0");
				m=0;
			}
			else m++;
		}

		if(m!=0) { // 끝에 나머지
			if(m==1) sb.append("1");
			else for(int j=0;j<m;++j) sb.append("0");

		}
		}
		System.out.println(sb.toString()); // 최대값

		// 최소값 구하기
		boolean pre=false;
		StringBuilder min=new StringBuilder();
		m=0;
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			if(c=='K') {
				if(m!=0) { // 앞에 m들 0 다 추가하기
					for(int j=0;j<m;++j) {
						if(j==0) min.append("1");
						else min.append("0");
					}
				}
				m=0;
				min.append("5");
			}else {
				m++;
			}

		}
		if(m!=0) {
			min.append("1");
			for(int i=1;i<m;++i) min.append("0");
		}

		System.out.println(min.toString());

	}

}
