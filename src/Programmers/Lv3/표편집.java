package Programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class 표편집 {

    @Test
    public void test(){
        Assertions.assertEquals("OOOOXOOO",solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        Assertions.assertEquals("OOXOXOOO",solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }

    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack=new Stack<>();

        for(String s:cmd){
            String [] c=s.split(" ");
            if(c[0].equals("U")){
                int num=Integer.parseInt(c[1]);
                k-=num;
                if(k<0) k+=n;
            }
            if(c[0].equals("D")){
                int num=Integer.parseInt(c[1]);
                k+=num;
                if(k>n-1) k-=n;
            }

            if(c[0].equals("C")){
                stack.push(k);
                if(k==n-1) k--;
                n--;
            }

            if(c[0].equals("Z")){
                int r=stack.pop();
                if(k>=r) k+=1; // pop한게 현재위치보다 앞에있으면 현재위치 밀려남
                n++;
            }
        }
        // n=7 stack =4
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i){
            sb.append("O");
        }
        // sb= "OOOOXOOO"
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(),"X");

        }

        return sb.toString();

    }

}
