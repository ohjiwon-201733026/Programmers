package BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1202_보석도둑 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();

        PriorityQueue<int []> orderW=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<N;++i){
            int m=sc.nextInt();
            int v=sc.nextInt();
            orderW.add(new int []{m,v});
        }
        int [] bag=new int [K];
        for(int i=0;i<K;++i){
            bag[i]=sc.nextInt();
        }

        Arrays.sort(bag);
        PriorityQueue<int []> orderV=new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[1]-o1[1];
                    }
                }
        );
        long answer=0;
        for(int i=0;i<bag.length;++i){
            int b=bag[i];
            while(!orderW.isEmpty()){
                if(b>=orderW.peek()[0]) orderV.add(orderW.poll());
                else break;
            }
            if(!orderV.isEmpty()) answer+=orderV.poll()[1];
        }

        System.out.println(answer);

    }
}
