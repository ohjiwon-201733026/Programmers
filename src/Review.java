import java.util.PriorityQueue;
import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		while(T-->0) {
			int N=sc.nextInt();
			int [] arr=new int [N];
			PriorityQueue<Long> pq=new PriorityQueue<>();
			for(int i=0;i<N;++i) {
				pq.add(sc.nextLong());
			}

			long result=0;
			while(pq.size()>1) {
				long a=pq.poll();
				long b=pq.poll();
				result+=a+b;
				pq.add(a+b);
			}

			System.out.println(result);

		}

	}
}
