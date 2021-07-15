package Programmers.Lv2;

public class 문자열압축 {

    public static void main(String[] args) {
        String s="ababcdcdababcdcd";
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int min=Integer.MAX_VALUE;
        for(int i=1;i<s.length();++i){
            if(min>compress(s,i)) min=compress(s,i);
        }

        return min;
    }

    private static int compress(String s, int n) {
        StringBuilder result=new StringBuilder();
        String pattern=s.substring(0,n);
        int count=1;
        for(int i=n;i<=s.length()-n;i+=n){
            if(s.substring(i,i+n).equals(pattern)) ++count;
            else{
                if(count>1) result.append(count);
                result.append(pattern);
                pattern=s.substring(i,i+n);
                count=1;
            }
        }

        if(count>1) result.append(count);
        result.append(pattern);
        int tail=s.length()%n;
        if(tail>0) result.append(s.substring(s.length()-tail));
        return result.toString().length();
    }
}
