package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1655_가운데를말해요 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap=new PriorityQueue<>();

        while(N-->0) {
            int a = Integer.parseInt(br.readLine());

            if(minheap.size()==maxheap.size()) maxheap.offer(a);
            else minheap.offer(a);

            if(!minheap.isEmpty()&&!maxheap.isEmpty()){
                if(minheap.peek()<maxheap.peek()){
                    int tmp=minheap.poll();
                    minheap.offer(maxheap.poll());
                    maxheap.offer(tmp);
                }

            }
            System.out.println(maxheap.peek());
        }

    }
}
