// A->B
package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B16953 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long A = Long.parseLong(str[0]);
        long B = Long.parseLong(str[1]);

        solution(A, B);
    }

    static void solution(long a, long target) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a, 0));

        while(!queue.isEmpty()) {
            Pair p = queue.poll();

            if(p.x==target){
                System.out.println(p.cnt+1);
                return;
            }

            for(int i=0; i<2; i++) {
                long x = 0;

                if(i==0) {
                    x = 2*p.x;
                }

                else {
                    x = 10*p.x + 1;
                }

                if(x<=target)
                    queue.add(new Pair(x, p.cnt+1));
            }
        }
        System.out.println(-1);
    }

    static class Pair {
        long x;
        int cnt;

        public Pair(long x, int cnt) {
            this.x=x;
            this.cnt=cnt;
        }
    }

}
