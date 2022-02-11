package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 거리두기확인하기 {

    @Test
    public void test(){
        int [] answer={1,0,1,1,1};
        int [] result=solution(new String [][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }
    static int [][] d1={{1,0},{0,1},{-1,0},{1,0}};
    static int [][] d2={{1,1},{1,-1},{-1,1},{-1,-1}};
    static int [][] d3={{0,2},{0,-2},{2,0},{-2,0}};
    static int [][] d={{0,1},{0,-1},{1,0},{-1,0}};
    public int [] solution(String [][] places){
        int [] answer=new int[places.length];

        for(int i=0;i< answer.length;++i) answer[i]=1;

        for(int i=0;i< places.length;++i){
            char [][] map=new char[5][5];
            String[] place=places[i];
            for(int j=0;j< place.length;++j){
                for(int t=0;t<place[j].length();++t){
                    map[j][t]=place[j].charAt(t);
                }
            }
            boolean flag=true;
            for(int j=0;j< place.length;++j){
                for(int t=0;t<place[j].length();++t){
                    if(map[j][t]=='P') flag=recur(j,t,map);
                    if(!flag) answer[i]=0;
                }
            }

        }
        return answer;

    }

    public boolean recur(int i, int j, char [][] map){

        for(int k=0;k<4;++k){
            int x= i+d1[k][0];
            int y= j+d1[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y]=='P') return false;
            }
        }


        for(int k=0;k<4;++k){
            int x= i+d2[k][0];
            int y= j+d2[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y]=='P' && (map[i][y]!='X' || map[x][j]!='X')) return false;
            }
        }

        for(int k=0;k<4;++k){
            int x= i+d3[k][0];
            int y= j+d3[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y]=='P' && map[i+d[k][0]][j+d[k][1]]!='X') return false;
            }
        }

        return true;
    }


}
