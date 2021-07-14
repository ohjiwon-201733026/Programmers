package BaekJoon.Strings;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B1316_그룹단어체커 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt=0;
        int N=sc.nextInt();

        for(int i=0;i<N;++i){
            String s=sc.next();

            boolean flag=true;
            HashMap<Character,Boolean> hm=new HashMap<>();

            String preString=press(s);
            char [] cArr=preString.toCharArray();
            for(char c='a';c<='z';++c) hm.put(c,false);
            for(char c:cArr){
                if(hm.get(c)) {flag=false;break;}
                else hm.put(c,true);

            }

            if(flag) { cnt++; }
        }

        System.out.println(cnt);

    }

    private static String press(String s) {

        Stack<Character> stack=new Stack<>();
        stack.add(s.charAt(0));
        for(int i=1;i<s.length();++i){
            char c=s.charAt(i);
            if(stack.peek()==c) continue;
            else stack.push(c);
        }


        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }

}
