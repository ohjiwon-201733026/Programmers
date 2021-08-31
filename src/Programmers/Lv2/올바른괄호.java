package Programmers.Lv2;

public class 올바른괄호 {
    public static void main(String [] args){
        String s="(()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        int n=0;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(') n++;
            else n--;
            if(n<0) return false;
        }
        if(n==0) return true;
        else return false;
    }
}
