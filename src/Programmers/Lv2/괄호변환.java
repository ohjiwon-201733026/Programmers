package Programmers.Lv2;

public class 괄호변환 {

    public static void main(String[] args){
        String p="()))((()";

        String answer=solution(p);
        System.out.println(answer);
    }


    public static String solution(String p){


            if(p.length()==0) return "";
            // 2
            int i=makeBalancedString(p);
            String u=p.substring(0,i+1);
            String v=p.substring(i+1);

            // 3
            if(correctString(u)) return u+solution(v);
            // 4
            StringBuilder sb=new StringBuilder("(");
            sb.append(solution(v)); // 4-2
            sb.append(")");
            sb.append(reverse(u));
            return sb.toString();


    }

    public static String reverse(String u){
        u=u.substring(1,u.length()-1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<u.length();++i){
            char c=u.charAt(i);
            if(c=='(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    public static int makeBalancedString(String s){
        int num=0;
        int i;
        for(i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(') num++;
            else num--;
            if(num==0) break;
        }
        return i;
    }


    public static boolean correctString(String s){
        if(s.charAt(0)==')') return false;
        int num=0;
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if(c=='(') num++;
            else num--;

            if(num<0) return false;

        }

        return true;
    }

}
