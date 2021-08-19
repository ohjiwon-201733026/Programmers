package Programmers.Lv3;

import java.util.Stack;

public class 표편집 {
    public static void main(String [] args){
        int n=8;
        int k=2;
        String [] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(solution(n,k,cmd));
    }

    public static String solution(int n, int k, String [] cmd) {
        Stack<Integer> remove=new Stack<>();
        int table_size=n;
        for(int i=0;i<cmd.length;++i){
            char c=cmd[i].charAt(0);

            if(c=='U'){
                k-=Integer.valueOf(cmd[i].substring(2));
            }
            else if(c=='D'){
                k+=Integer.valueOf(cmd[i].substring(2));
            }
            else if(c=='C'){
                remove.push(k);
                table_size--;
                if(k==table_size) k-=1;
            }
            else{
                int r=remove.pop();
                if(k>=r) k+=1;
                table_size+=1;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<table_size;++i){
            sb.append("O");
        }
        System.out.println(sb);

        while(!remove.isEmpty()){
            System.out.println(remove.peek());
            sb.insert(remove.pop().intValue(),'X');
        }
        return sb.toString();
    }

}
