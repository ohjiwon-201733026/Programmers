package Programmers.Lv1;

public class 약수의개수와덧셈 {

    public static void main(String[] args) {
        int left=13;
        int right=17;
        int answer=solution(left,right);
        System.out.println(answer);
    }

    private static int solution(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;++i){
            if(count(i)) sum+=i;
            else sum-=i;
        }

        return sum;
    }

    private static boolean count(int i) {
        double a=Math.sqrt(i);
        int n=(int)a;
        if(a-n==0) return false; // 홀수개
        else return true; // 짝수개

    }
}
