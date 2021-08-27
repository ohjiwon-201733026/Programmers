package BaekJoon.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class B20114_미아노트 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); // 전체 길이
        int H=sc.nextInt(); // 세로 번진 길이
        int W=sc.nextInt(); // 가로 번진 길이

        char [][] arr=new char [H][N*W];
        for(int i=0;i<H;++i){
            String s=sc.next();
            arr[i]=s.toCharArray();
        }

        char [] r=new char[arr[0].length]; // 세로 합치기

        for(int j=0;j<arr[0].length;++j){
            for(int i=0;i<H;++i) {
                if (arr[i][j] != '?') r[j] = arr[i][j];
            }
        }

        char [] answer=new char [N];
        Arrays.fill(answer,'?');
        int idx=0;
        for(int i=0;i<r.length;i+=W){ //0, 2, 4
           for(int j=0;j<W;++j){// 0+0,0+1, 2+0 ,...
               if(Character.isLowerCase(r[i+j])) {
                    answer[idx]=r[i+j];
                    break;
               }
           }
            idx++;
        }

        for(int i=0;i< answer.length;++i){
            System.out.print(answer[i]);
        }


    }
}
