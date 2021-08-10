package Programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n=2;
        String [] words={"hello", "one", "even", "never", "now", "world", "draw"};
        int [] answer=solution(n,words);
        System.out.println(answer[0]+" "+answer[1]);
    }

    public static int [] solution(int n,String [] words){
        int [] answer=new int[2];
        char pre=words[0].charAt(0);
        Set<String> set=new HashSet<>();
        int i;
        for(i=0;i< words.length;++i){
            String word=words[i];
            if(set.contains(word)) break;
            if(pre!=word.charAt(0)) break;
            else {
                set.add(word);
                pre = word.charAt(word.length() - 1);
            }

        }
        if(i< words.length){
            answer[0]=(int)Math.ceil((i+1)%n)==0?n:(int)Math.ceil((i+1)%n);
            answer[1]=(i+1)/n==0?(i+1)/n:(i+1)/n+1;
        }
        else { answer[0]=0; answer[1]=0;}

        return answer;
    }
}
