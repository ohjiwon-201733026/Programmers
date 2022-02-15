package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    @Test
    public void test(){
        int [] result1=solution(new int []{93, 30, 55},new int []{1,30,5});
        int [] result2=solution(new int []{95, 90, 99, 99, 80, 99},new int []{1,1,1,1,1,1});

        Assertions.assertEquals(result1[0],2);
        Assertions.assertEquals(result1[1],1);
        Assertions.assertEquals(result2[0],1);
        Assertions.assertEquals(result2[1],3);
        Assertions.assertEquals(result2[2],2);
    }

    public int [] solution(int [] progresses, int [] speeds){
        Queue<Integer> q=new LinkedList<>();

        for (int i=0;i<progresses.length;++i) {
            double n=(double)(100-progresses[i])/speeds[i];
            if(n%1==0) q.add((int)n);
            else q.add((int)n+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int p=q.poll();
            int cnt=1;
            while(true){
                if(q.isEmpty())break;
                if(q.peek()>p) break;
                else{
                    cnt++;
                    q.poll();
                }
            }

            list.add(cnt);
        }
        int [] a=new int [list.size()];
        for (int i=0;i<list.size();++i) {
            a[i]=list.get(i);
        }
        return a;
    }
}
