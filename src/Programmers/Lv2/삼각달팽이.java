package Programmers.Lv2;

import java.util.ArrayList;

public class 삼각달팽이 {
    public static void main(String [] args){
        int n=4;
        int [] result=solution(n);
        for(int i:result) System.out.println(i);
    }

    public static int[] solution(int n){
        int [][] arr=new int [n][n];
        int cnt=1;
        int x=-1,y=0;
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                if(i%3==0) {
                    x++;
                }
                if(i%3==1){
                    y++;
                }
                if(i%3==2){
                    x--;
                    y--;
                }
                arr[x][y]=cnt++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(arr[i][j]!=0) sb.append(arr[i][j]+" ");
//                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(sb.toString());

        String [] s=sb.toString().split(" ");
        int answer[]=new int [s.length];
        for(int i=0;i<s.length;++i){
            answer[i]=Integer.parseInt(s[i]);
        }

        return answer;
    }
}
