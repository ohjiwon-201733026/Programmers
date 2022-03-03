package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class 영어끝말잇기 {

    @Test
    public void test(){
        int [] answer=solution(3,
                new String []{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        int [] result={3,3};
        Assertions.assertEquals(result[0],answer[0]);
        Assertions.assertEquals(result[1],answer[1]);
    }

    public int [] solution(int n, String [] words){
        HashSet<String> set=new HashSet<>();

        set.add(words[0]);
        char c=words[0].charAt(words[0].length()-1);
        int i=0;
        boolean flag=true;
        for(i=1;i<words.length;++i){
            String word=words[i];
            if(word.startsWith(c+"") && !set.contains(word) && word.length()!=1){
                c=word.charAt(word.length()-1);
                set.add(word);
            }
            else {
                break;
            }
        }
        if(i== words.length) return new int []{0,0};
        System.out.println(i);
        int a=(i)%n+1;
        double d=(double)i/n;
        return new int []{a, (int)d+1};
    }
}
