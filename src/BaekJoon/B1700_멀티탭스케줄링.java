package BaekJoon;

import java.io.*;
import java.util.*;

public class B1700_멀티탭스케줄링 {
    static PriorityQueue<Integer> [] count;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int [] arr=new int [k];

        count=new PriorityQueue[k+1];
        for(int i=0;i<=k;++i) count[i]=new PriorityQueue<>();

        for(int i=0;i<k;++i){
            arr[i]=sc.nextInt();
            count[arr[i]].add(i);
        }
        HashSet<Integer> set=new HashSet<>();
        int answer=0;
        for(int i=0;i<k;++i){
            int cur=arr[i];
            if(set.contains(cur)){ // 이미 꽂혀있는 경우
                count[cur].remove(i);
                continue;
            }
            if(set.size()<n){ // 멀티탭에 여유 있는 경우
                set.add(cur);
                count[cur].remove(i);
            }
            else{ // 하나를 빼고 꽂아야하는 경우
                int max=0;
                int j=0;

                for (Integer t : set) {
                    if(count[t].isEmpty()){
                        max=Integer.MAX_VALUE;
                        j=t;
                    }
                    else if(max<count[t].peek()){
                        max=count[t].peek();
                        j=t;
                    }
                }

                set.remove(j);
                set.add(cur);
                count[cur].poll();
                answer++;
            }
        }

        System.out.println(answer);

    }
}
