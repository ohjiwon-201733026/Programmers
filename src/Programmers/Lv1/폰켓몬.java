package Programmers.Lv1;

import java.util.ArrayList;

public class 폰켓몬 {

    public static void main(String[] args) {
        int [] nums={3,1,2,3};
        int answer=solutions(nums);
        System.out.println(answer);
    }

    private static int solutions(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;++i){
            if(!list.contains(nums[i])) list.add(nums[i]);
        }

        if(list.size()>nums.length/2) return nums.length/2;
        else return list.size();

    }
}
