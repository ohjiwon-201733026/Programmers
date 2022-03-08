package programmers2.level3;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class 이중우선순위큐 {

    @Test
    public void test(){
        int [] answer={7,5};

        int [] result=solution(new String []{"I 7","I 5","I -5","D -1"});

        Assertions.assertEquals(answer[0],result[0]);
        Assertions.assertEquals(answer[1],result[1]);
    }

    public int [] solution(String [] operations){
        PriorityQueue<Integer> max=new PriorityQueue<>((o1,o2)->o2-o1);
        PriorityQueue<Integer> min=new PriorityQueue<>();

        for (String operation : operations) {
            String op=operation.split(" ")[0];

            if(op.equals("I")){
                int val=Integer.parseInt(operation.split(" ")[1]);
                max.add(val);
                min.add(val);
            }

            if(operation.equals("D 1")){
                if(max.isEmpty()) continue;
                int num=max.poll();
                min.remove(num);
            }

            if(operation.equals("D -1")){
                if(min.isEmpty()) continue;
                int num=min.poll();
                max.remove(num);
            }

        }

        if(max.size()==0 && min.size()==0) return new int []{0,0};

        int a=max.poll();
        int b=min.poll();

        return new int []{a,b};
    }
}
