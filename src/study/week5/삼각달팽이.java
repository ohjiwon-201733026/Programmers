package study.week5;

import java.io.IOException;
import java.util.ArrayList;

public class 삼각달팽이 {
// n=4
// 1
// 2  9
// 3 10 8
// 4  5 6 7
    public static void main(String[] args) throws IOException {
        int n = 6;
        int[] result = solution(n);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] answer;
        int num = 1;
        int x=-1,y=0;
        for(int i=0;i<n;++i){
            for(int j=i;j<n;++j){
                if(i%3==0){
                    x++;
                }
                else if(i%3==1){
                    y++;
                }
                else if(i%3==2){
                    x--;
                    y--;
                }

                arr[x][y]=num++;
            }
        }
            ArrayList<Integer> list=new ArrayList<>();
            for (int k = 0; k < n; ++k) {
                for (int l = 0; l <= k; ++l) {
                    if (arr[k][l] != 0) list.add(arr[k][l]);
                }
            }
            answer =new int [list.size()];
            for(int k=0;k< answer.length;++k){
                answer[k]=list.get(k);
            }


            return answer;
        }

}
