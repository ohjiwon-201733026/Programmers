package Programmers.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        String begin="hit";
        String target="cog";
        String [] words={"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin,target,words));
    }
    public static boolean [] visit;
    public static int solution(String begin, String target, String[] words) {
        Queue<Word> q=new LinkedList<>();
        visit=new boolean[words.length];

        q.add(new Word(begin,0));

        while(!q.isEmpty()) {

            Word a=q.poll();

            if (a.w.equals(target)) return a.cnt;

            for (int i = 0; i < words.length; ++i) {

                if ( countDiff(a.w, words[i]) && !visit[i] ) {
                    q.add(new Word(words[i],a.cnt+1));
                    visit[i] = true;
                }
            }
        }


        return 0;
    }

    public static class Word{
        String w;
        int cnt;

        public Word(String w, int cnt){
            this.w=w;
            this.cnt=cnt;
        }
    }

    public static boolean countDiff(String s1, String s2){
        int cnt=0;
        for(int i=0;i<s1.length();++i){
            if(s1.charAt(i)!=s2.charAt(i)) cnt++;
        }

        return cnt==1?true:false;
    }


}
