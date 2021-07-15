package Programmers.Lv2;

public class 타겟넘버 {
    public static void main(String[] args) {
        int [] numbers={1,1,1,1,1};
        int target=3;
        int answer=solution(numbers,target);
        System.out.println(answer);
    }
    public static int count=0;
    private static int solution(int[] numbers, int target) {

        int answer=dfs(numbers,target,0,0);
        return answer;
    }

    public static int dfs(int [] numbers, int target, int idx, int val) {
        if (idx == numbers.length){
            if(val==target) return 1;
            else return 0;
        }


        return dfs(numbers, target, idx + 1, val + numbers[idx] * -1)
            +dfs(numbers, target, idx + 1, val + numbers[idx]);


    }
}
