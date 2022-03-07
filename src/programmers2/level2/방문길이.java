package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 방문길이 {

    @Test
    public void test(){
        Assertions.assertEquals(7,solution("LULLLLLLU"));
    }
    // r,d,l,u
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    static boolean [][][] map;
    static int answer=0;
    public int solution(String dirs){
        map=new boolean [11][11][4];

        int x=5,y=5;

        for (char c : dirs.toCharArray()) {
            int idx=index(c);
            int dir=func(idx);
            int a=x,b=y;

            x+=dx[idx];
            y+=dy[idx];

            if(x<0 || 10<x || y<0 || 10<y ) {
                x-=dx[idx];
                y-=dy[idx];
                continue;
            }

            if(!map[a][b][idx] && !map[x][y][dir]){
                answer++;
                map[a][b][idx]=map[x][y][dir]=true;
            }

        }

        return answer;
    }

    public int index(char c){
        switch (c){
            case 'R': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'U': return 3;
        }
        return -1;
    }


    public int func(int idx){
        if(idx==0) return 2;
        if(idx==2) return 0;
        if(idx==1) return 3;
        if(idx==3) return 1;
        return -1;
    }
}
