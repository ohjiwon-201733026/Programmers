package study.week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class 방문길이 {

    public static void main(String[] args) {
        String dirs="ULURRDLLU";
        int answer=solution(dirs);
        System.out.println(answer);
    }


    private static int solution(String dirs) {
        int answer=0;

        int [][] map=new int [11][11];
        int curX=5; // 원래 좌표 0 +5
        int curY=5; // 원래 좌표 0 +5

        for(int i=0;i<dirs.length();++i){
            char dir=dirs.charAt(i);
            int nextX=curX;
            int nextY=curY;
            switch (dir){
                case 'U':nextY=curY+1;break;
                case 'D':nextY=curY-1;break;
                case 'R':nextX=curX+1;break;
                case 'L':nextX=curX-1;break;
            }

            if(map[nextX][nextY]!=0 && map[curX][curY]>=1) continue;
//            else
        }
        return answer;
    }
}
