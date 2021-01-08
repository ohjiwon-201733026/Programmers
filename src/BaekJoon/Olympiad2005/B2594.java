//놀이공원
package BaekJoon.Olympiad2005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class B2594 {

	public static class Time{
		int start;
		int end;

		public Time(int start, int end) {
			this.start=jeon(start);
			this.end=hu(end);
		}

//		public void print() {
//			System.out.println(this.start+" ~ "+this.end);
//		}

		public int jeon(int a) { //시작시간 -10분
			int si=a/100;
			int bun=a%100;

			if(bun<=10) {
				si=si-1;
				bun=50+bun;
			}
			else {
				bun-=10;
			}
			String answer=Integer.toString(si)+Integer.toString(bun);

			return Integer.parseInt(answer);
		}

		public int hu(int a) { // 마감시간 +10분
			int si=a/100;
			int bun=a%100;

			if(bun>=50) {
				si+=1;
				bun=bun+10-60;
			}
			else {
				bun+=10;
			}

			return si*100+bun;
		}


	}



	public static int minus(int x,int y) {
		int xSi=x/100;
		int xBun=x%100;
		int ySi=y/100;
		int yBun=y%100;

		int si=ySi-xSi;
		int bun=yBun-xBun;

		if(bun<0) {
			si-=1;
			bun+=60;
		}
//		System.out.println(si*60+bun);
		return si*60+bun;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Time [] timeTable=new Time[n];
		Vector<Integer> v=new Vector<>();

		for(int i=0;i<n;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			timeTable[i]=new Time(start,end);
		}


		Arrays.sort(timeTable,new Comparator<Time>(){

			@Override
			public int compare(Time o1, Time o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}

		});
//		System.out.println("start시간 기준 정렬");
//		FOR(INT I=0;I<TIMETABLE.LENGTH;I++) {
//			TIMETABLE[I].PRINT();
//		}


		int len=timeTable.length;
		int e=minus(1000,timeTable[0].start);
		if(e>0) v.add(e); // 오픈 시간~첫번째 놀이기구 시작시간
		for(int i=1;i<timeTable.length;i++) {
			int tmp=minus(timeTable[i-1].end,timeTable[i].start);
			if(tmp<0) continue;
			else v.add(tmp);
		}

		int last=0;
		for(int i=0;i<timeTable.length;++i) {
			if(timeTable[i].end>last) last=timeTable[i].end;
		}

		e=minus(last,2200);
		if(e>0) v.add(e);
//		System.out.println(v);


		int max=0;
		for(int i=0;i<v.size();i++) {
			int a=v.get(i);
			if(a>max) max=a;
		}
		System.out.println(max);

	}

}
