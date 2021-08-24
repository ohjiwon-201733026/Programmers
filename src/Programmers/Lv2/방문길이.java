package Programmers.Lv2;

import java.util.HashMap;

public class 방문길이 {
    public static void main(String [] args){
        String dirs="LULLLLLLU";
        System.out.println(solution(dirs));
    }
    public static HashMap<Character,Integer> idx=new HashMap<>();
    public static int solution(String dirs){
        int answer=0;
        int [][][] map=new int [11][11][4];
        idx.put('U',0);
        idx.put('D',1);
        idx.put('L',2);
        idx.put('R',3);

        int x=5,y=5;
        for(char dir:dirs.toCharArray()){
            int curX=x, curY=y;
            char c=dir;
            if(dir=='U') {x--; c='D';}
            if(dir=='D') {x++; c='U';}
            if(dir=='L') {y--; c='R';}
            if(dir=='R') {y++; c='L';}

            if(0<=x && x<11 && 0<=y &&y <11){
                System.out.println(curX+" "+curY);
                if(map[curX][curY][idx.get(dir)]!=1 && map[x][y][idx.get(c)]!=1 ) {
                    answer++;
                    map[curX][curY][idx.get(dir)]=1;
                    map[x][y][idx.get(c)]=1;
                }
            }
            else{
                x=curX; y=curY;
            }

        }

        return answer;
    }
}
