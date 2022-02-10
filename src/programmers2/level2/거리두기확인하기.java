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
    static int [][] d1={{0,1},{0,-1},{1,0},{-1,0}};
    static int [][] d2={{1,1},{1,-1},{-1,1},{-1,-1}};
    static int [][] d3={{2,0},{-2,0},{0,2},{0,-2}};
    static int [][] d={{1,0},{-1,0},{0,1},{0,-1}};
    public int [] solution(String [][] places){

        int [] answer=new int [places.length];
        for(int i=0;i<answer.length;++i){
            answer[i]=1;
        }

        for(int k=0;k<places.length;++k){
            String [] place=places[k];

            String [][] map=new String[5][5];
            for(int i=0;i<place.length;++i){
                for(int j=0;j<place.length;++j){
                    map[i][j]=place[i].charAt(j)+"";
                }
            }
            boolean flag=true;
            for(int i=0;i<map.length;++i){
                for(int j=0;j<map.length;++j){
                    if(map[i][j].equals("P")) flag=recur(i,j,map);
                    if(!flag) answer[k]=0;
                }
            }
        }
        return answer;
    }

    public boolean recur(int i, int j, String [][] map){


        for(int k=0;k<d1.length;++k){
            int x=i+d1[k][0];
            int y=j+d1[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y].equals("P")) return false;
            }
        }

        for(int k=0;k<d2.length;++k){
            int x=i+d2[k][0];
            int y=j+d2[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y].equals("P") && (!map[x][j].equals("X") || !map[i][y].equals("X") )) return false;
            }
        }

        for(int k=0;k<d3.length;++k){
            int x=i+d3[k][0];
            int y=j+d3[k][1];
            if(0<=x && x<5 && 0<=y && y<5){
                if(map[x][y].equals("P") && !map[i+d[k][0]][j+d[k][1]].equals("X")) return false;
            }
        }

        return true;

    }


}
