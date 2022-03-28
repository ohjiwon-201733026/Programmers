package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B14719_빗물 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int H=sc.nextInt();
        int W=sc.nextInt();
        int [] map=new int [W];
        int ret=0,left=0,right=0;

        for(int i=0;i<W;++i) map[i]=sc.nextInt();

        for(int i=0;i<W-1;++i){
            left=right=0;

            for(int j=0;j<i;++j) left=Math.max(map[j],left);
            for(int j=0;j<i;++j) right=Math.max(map[j],right);

            if(map[i]<left && map[i]<right) ret+=Math.min(left,right)-map[i];
        }

        System.out.println(ret);

    }
}
