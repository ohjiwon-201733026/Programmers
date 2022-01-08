package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    @Test
    public void test(){
        Assertions.assertEquals(4, solution("hit","cog"
        ,new String []{"hot", "dot", "dog", "lot", "log", "cog"}));
//        Assertions.assertEquals(0, solution("hit","cog"
//                ,new String []{"hot", "dot", "dog", "lot", "log", "cog"}));

    }
    static boolean [] visited;
    public static int solution(String begin, String target, String [] words){
        visited=new boolean[words.length];

        return bfs(begin,target,words);
    }
    static int bfs(String begin,String target,String [] words){
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(begin,0));

        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.word.equals(target)) return p.cnt;

            for(int i=0;i< words.length;++i){
                if(visited[i]) continue;
                if(check(p.word,words[i])){
                    q.add(new Point(words[i],p.cnt+1));
                    visited[i]=true;
                }
            }
        }
        return 0;
    }
    static class Point{
        String word;
        int cnt;

        public Point(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static boolean check(String a,String b){
        if(a.length()!=b.length()) return false;
        int cnt=0;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt==1;
    }
}
