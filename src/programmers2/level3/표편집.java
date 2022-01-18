package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 표편집 {

    @Test
    public void test(){
        Assertions.assertEquals("OOOOXOOO"
                ,solution(8,2,new String []{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        Assertions.assertEquals("OOXOXOOO"
                ,solution(8,2,new String []{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }

    public String solution(int n, int k, String [] cmd){
        Stack<Integer> stack=new Stack<>();

        for (String s : cmd) {
            String [] op=s.split(" ");
            if(op[0].equals("U")){
                int num=Integer.parseInt(op[1]);
                k-=num;
                if(k<0) k+=n;
            }
            else if(op[0].equals("D")){
                int num=Integer.parseInt(op[1]);
                k+=num;
                if(k>=n) k-=n;
            }
            else if(op[0].equals("C")){
                stack.push(k);
                if(k==n-1) k--;
                n--;

            }
            else if(op[0].equals("Z")){
                int i=stack.pop();
                n++;
                if(i<=k) k++;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i) sb.append("O");

        while(!stack.isEmpty()){
            int i=stack.pop();
            sb.insert(i,"X");
        }

        return sb.toString();
    }
}
