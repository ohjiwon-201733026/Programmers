package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B12015_가장긴증가하는부분수열2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<n;++i){
            int num=sc.nextInt();
            if(list.size()==0) list.add(num);
            else{
                if(list.get(list.size()-1)<num) list.add(num);
                else{
                    int left=0;
                    int right=list.size()-1;

                    while (left<right){
                        int mid=(left+right)/2;

                        if(list.get(mid)>=num){
                            right=mid;
                        }
                        else{
                            left=mid+1;
                        }
                    }

                    list.set(right,num);

                }
            }
        }

        System.out.println(list.size());
    }

}
