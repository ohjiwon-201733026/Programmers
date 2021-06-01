import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> crane=new ArrayList<>();
		for(int i=0;i<N;++i) {
			crane.add(sc.nextInt());
		}
		int M=sc.nextInt();
		ArrayList<Integer> box=new ArrayList<>();
		for(int i=0;i<M;++i) {
			box.add(sc.nextInt());
		}

		Collections.sort(crane,Collections.reverseOrder());
		Collections.sort(box,Collections.reverseOrder());
		int time=0;

		if(crane.get(0)<box.get(0)) {
			System.out.println(-1);
		}
		else {

			while(box.size()!=0) {
				int idx=0; //crane index
				int tmp=0; // box index
				while(idx<N) {
					if(tmp==box.size()) break;
					if(box.get(tmp)<=crane.get(idx)) {
						box.remove(tmp);
						idx++;
					}
					else if(box.get(tmp)>crane.get(idx)) tmp++;
				}
			time++;
		}

		System.out.println(time);
	}
	}
}
