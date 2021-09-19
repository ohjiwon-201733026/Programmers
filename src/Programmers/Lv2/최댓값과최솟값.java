package Programmers.Lv2;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        String s="1 2 3 4";
        System.out.println(solution(s));
    }

    public static String solution(String s){
        String [] arr=s.split(" ");
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i< arr.length;++i){
            int num=Integer.parseInt(arr[i]);
            if(max<num) max=num;
            if(min>num) min=num;
        }

        return min+" "+max;
    }
}
