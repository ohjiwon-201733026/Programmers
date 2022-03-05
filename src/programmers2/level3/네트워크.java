package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 네트워크 {

    @Test
    public void test(){
//        Assertions.assertEquals(2,solution(3,new int [][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1,solution(3,new int [][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static List<Integer>[] map;
    static boolean [] visited;
    static int answer=0;
    public int solution(int n, int [][] computers){
        map=new ArrayList[n];
        visited=new boolean[n];
        for(int i=0;i<n;++i) map[i]=new ArrayList<>();

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(computers[i][j]==1){
                    map[i].add(j);
                    map[j].add(i);
                }
            }
        }
        for(int i=0;i<n;++i){
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;

    }


    public void dfs(int i){
        visited[i]=true;
        for (Integer n : map[i]) {
            if(!visited[n]){
                visited[n]=true;
                dfs(n);
            }
        }
    }


}
