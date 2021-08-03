import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();

		HashSet<String> list=new HashSet<>();

		for(int i=0;i<N;++i) list.add(sc.next());

		ArrayList<String> inter=new ArrayList<>();
		int answer=0;
		for(int i=0;i<M;++i){
			String s=sc.next();
			if(list.contains(s)) { inter.add(s); }
		}
		Collections.sort(inter);
		System.out.println(inter.size());
		for(String s:inter) System.out.println(s);

	}

}
