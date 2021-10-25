package BaekJoon.Implementation;

import java.util.Scanner;

public class B14719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H=sc.nextInt();
        int W=sc.nextInt();
        int [] map=new int [W];
        int ret=0,left=0,right=0;


        for(int i=0;i<W;++i){
            map[i]=sc.nextInt();
        }

        for(int i=1;i<W-1;++i){
            left=right=0;
            // 왼쪽에서 가장 높은 건물의 높이
            for(int j=0;j<i;++j){
                left=Math.max(map[j],left);
            }
            // 오른쪽에서 가장 높은 건물의 높이
            for(int j=i+1;j<W;++j){
                right=Math.max(map[j],right);
            }
            // 더 낮은 건물을 기준으로 현재 인덱스에 모이는 빗물
            if(map[i]<left && map[i]<right){
                ret+=Math.min(left,right)-map[i];
            }
            // 제일 높다면 채울수 없으므로 더하지 않는다

        }
        System.out.println(ret);



    }
}
