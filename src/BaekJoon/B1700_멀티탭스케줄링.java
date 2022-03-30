package BaekJoon;

import java.io.*;
import java.util.*;

public class B1700_멀티탭스케줄링 {
static PriorityQueue<Integer> [] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int [] order=new int [k];

        arr=new PriorityQueue[k+1];
        for(int i=0;i<=k;++i) arr[i]=new PriorityQueue<>();

        for(int i=0;i<k;++i){
            int num=sc.nextInt();
            order[i]=num;
            arr[num].add(i);
        }
        int answer=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<k;++i){
            int cur=order[i];
            if(set.contains(cur)){ // 이미 꽂혀있는 경우
                arr[cur].remove(i);
                continue;
            }
            else{ // 아닌 경우
                if(set.size()<n){ // 여유 자리 있는 경우
                    set.add(cur);
                    arr[cur].remove(i);
                }
                else{ // 여유자리 없는 경우(하나빼고 꽂기)
                    int plug=0;
                    int max=0;
                    for (Integer tab : set) {
                        if(arr[tab].isEmpty()){ // 앞으로 사용 안하는 플러그인 경우
                            max=Integer.MAX_VALUE;
                            plug=tab;
                        }
                        else if(max<arr[tab].peek()){ // 앞으로 사용하는 플러그인 -> 가장 나중에 사용하는 플러그인
                            max=arr[tab].peek();
                            plug=tab;
                        }
                    }

                    set.remove(plug);
                    set.add(cur);
                    arr[cur].remove(i);
                    answer++;

                }
            }
        }
        System.out.println(answer);

    }
}
