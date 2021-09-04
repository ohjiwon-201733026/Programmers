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

        Stack<Integer> stack=new Stack<>();

        for(String c: cmd){
            String [] s=c.split(" ");
            if(s[0].equals("U")){
                int a=Integer.parseInt(s[1]);
                k-=a;
                if(k<0) k+=n;
            }
            else if(s[0].equals("D")){
                int a=Integer.parseInt(s[1]);
                k+=a;
                if(k>=n) k-=n;
            }
            else if(s[0].equals("C")){
                stack.add(k);
                if(k==n-1){
                    k--;
                }
                n--;
            }
            else{
                int r=stack.pop();
                if(k>=r) k+=1;
                n++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i){
            sb.append("O");
        }

        while(!stack.isEmpty()){
            int a=stack.pop();
            sb.insert(a,"X");
        }
        return sb.toString();
    }

}
