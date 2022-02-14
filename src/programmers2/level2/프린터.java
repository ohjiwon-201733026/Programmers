package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    @Test
    public void test(){
        Assertions.assertEquals(1,solution(new int []{2, 1, 3, 2},2));
        Assertions.assertEquals(5,solution(new int []{1, 1, 9, 1, 1, 1},0));
    }

    class Doc{
        int idx;
        int prior;

        public Doc(int idx, int prior) {
            this.idx = idx;
            this.prior = prior;
        }

        @Override
        public String toString() {
            return "Doc{" +
                    "idx=" + idx +
                    ", prior=" + prior +
                    '}';
        }
    }
    public int solution(int [] priorities, int location){
        LinkedList<Doc> q=new LinkedList<>();
        for(int i=0;i< priorities.length;++i){
            q.add(new Doc(i,priorities[i]));
        }

        int cnt=1;
        while (true){
            Doc d=q.remove(0);

            boolean flag=false;

            for(int i=0;i<q.size();++i){
                if(q.get(i).prior>d.prior){
                    flag=true;
                    break;
                }

            }


            if(flag) q.add(d);
            else {
                if(d.idx==location) break;
                cnt++;
            }
        }

        return cnt;
    }
}
