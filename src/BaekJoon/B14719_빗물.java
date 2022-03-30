package BaekJoon;

import java.util.Scanner;

public class B14719_빗물 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int H=sc.nextInt();
        int W=sc.nextInt();
        int [] arr=new int [W];
        for(int i=0;i<W;++i) arr[i]=sc.nextInt();
        int answer=0;

        for(int i=0;i<W;++i){
            int cur=arr[i];
            int left=arr[i];
            int right=arr[i];
            for(int j=0;j<i;++j) left=Math.max(left,arr[j]);
            for(int j=i+1;j<W;++j) right=Math.max(right,arr[j]);

            answer+=Math.min(left,right)-cur;

        }

        System.out.println(answer);

    }
}
