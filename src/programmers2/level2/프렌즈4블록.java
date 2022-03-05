package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 프렌즈4블록 {

    @Test
    public void test(){
        Assertions.assertEquals(14,solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        Assertions.assertEquals(15,solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    static char [][] map;
    public int solution(int m, int n, String [] board){
        int answer=0;
        map=new char[m][n];
        for(int i=0;i<board.length;++i){
            map[i]=board[i].toCharArray();
        }
        boolean [][] visited;

        while (true){
            visited=new boolean[m][n];
            for(int i=0;i<m-1;++i){
                for(int j=0;j<n-1;++j){
                    char c=map[i][j];
                    if(c!='-'&&map[i+1][j]==c && map[i][j+1]==c && map[i+1][j+1]==c){
                        visited[i][j]=visited[i+1][j]=visited[i][j+1]=visited[i+1][j+1]=true;
                    }
                }
            }

            int cnt=count(visited);
            if(cnt==0) break;
            answer+=cnt;

            for(int j=0;j<n;++j) {
                if(visited[0][j]) map[0][j]='-';
            }

            for(int i=1;i<m;++i){
                for(int j=0;j<n;++j){
                    if(visited[i][j]){
                        for(int k=i-1;k>=0;k--){
                            map[k+1][j]=map[k][j];
                            map[k][j]='-';
                        }
                    }
                }
            }


        }
        return answer;
    }

    public int count(boolean[][] visited){
        int cnt=0;
        for(int i=0;i<visited.length;++i){
            for(int j=0;j<visited[0].length;++j){
                if(visited[i][j]) cnt++;
            }
        }

        return cnt;
    }
}
