package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B12015_가장긴증가하는부분수열2 {

    static int n;
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        list=new ArrayList<>();
        list.add(0);

        for(int i=0;i<n;++i){
            int num=sc.nextInt();

            if(list.get(list.size()-1)<num) list.add(num);
            else{
                int left=0;
                int right=list.size()-1;

                while (left<right){
                    int mid=(left+right)/2;
                    if(list.get(mid)>=num) right=mid;
                    else left=mid+1;
                }

                list.set(right,num);

            }
        }
        System.out.println(list.size()-1);
    }

    static int binarySearch(int target){
        int left=0;
        int right=list.size();
        int idx=0;

        while (left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)<target){
                left=mid+1;
            }
            else{
                right=mid-1;
                idx=mid;

            }
        }

        return idx;
    }
}
