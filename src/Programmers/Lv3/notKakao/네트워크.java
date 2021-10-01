package Programmers.Lv3.notKakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 네트워크 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1,solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    static boolean [] visited;
    static int N;
    static HashMap<Integer, ArrayList<Integer>> connect=new HashMap<>();
    public int solution(int n, int[][] computers) {
        visited=new boolean[n];
        N=n;
        int answer=0;
        for(int i=0;i<n;++i){
            ArrayList<Integer> tmp=new ArrayList<>();
            for(int j=0;j<n;++j){
                if(i!=j){
                    if(computers[i][j]==1) tmp.add(j);
                }
            }
            connect.put(i,tmp);
        }

        for(int i=0;i<n;++i){
            if(!visited[i]){
                answer++;
                visited[i]=true;
                dfs(i);
            }
        }
        return answer;
    }

    private void dfs(int i) {

        ArrayList<Integer> list=connect.get(i);
        for(int j:list){
            if(!visited[j]){
                visited[j]=true;
                dfs(j);
            }
        }
    }
}
