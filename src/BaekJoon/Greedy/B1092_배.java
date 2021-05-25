package BaekJoon.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1092_배 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> crane=new ArrayList<>();
		for(int i=0;i<N;++i) crane.add(sc.nextInt());
		int M=sc.nextInt();
		ArrayList<Integer> box=new ArrayList<>();
		for(int i=0;i<M;++i) box.add(sc.nextInt());

		Collections.sort(crane,Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		int time=0;
		if(crane.get(0)<box.get(0)) {
			System.out.println(-1);
		}
		else {
			while(box.size()!=0) {
				int idx=0; // crane index
				int tmp=0; // box index
				while(idx<N) { // crane 한바퀴
					if(tmp==box.size()) break; // box 한 회차 다 옮김
					if(box.get(tmp)<=crane.get(idx)) { // 옮길 수 있는 경우
						box.remove(tmp);
						idx++; // idx 크레인은 이미 실음, 다음 크레인
					}
					else if(box.get(tmp)>crane.get(idx)) tmp++; // 다음 회차에 넘기기, 다음 작은 박스부터

				}
				time++;
			}

			System.out.println(time);

		}

	}

}
