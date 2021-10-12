package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    @Test
    public void test(){
//        Assertions.assertEquals(new int[]{0,0},solution(new String[]{"I 16","D 1"}));
//        Assertions.assertEquals(new int[]{7,5},solution(new String[]{"I 7","I 5","I -5","D -1"}));
        int [] answer=solution(new String[]{"I 7","I 5","I -5","D -1"});
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> asc=new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> des=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(String s:operations){
            String [] o=s.split(" ");
            if(o[0].equals("I")){
                int n=Integer.parseInt(o[1]);
                asc.offer(n);
                des.offer(n);
            }
            if(o[0].equals("D")){
                int op=Integer.parseInt(o[1]);
                if(!asc.isEmpty()) {
                    if (op == 1) {
                        int max = des.poll();
                        asc.remove(max);
                    }

                    if (op == -1) {
                        int min = asc.poll();
                        des.remove(min);
                    }
                }
            }
        }
        if(des.isEmpty()) return new int[]{0,0};

        return new int[]{des.poll(),asc.poll()};

    }
}
