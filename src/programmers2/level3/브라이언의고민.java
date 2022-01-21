package programmers2.level3;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class 브라이언의고민 {
    @Test
    public void test() {
//        Assertions.assertEquals("HELLO WORLD", solution("aHbEbLbLbOacWdOdRdLdDc"));
//        Assertions.assertEquals("SIGONG JOA",solution("SpIpGpOpNpGJqOqA"));
        Assertions.assertEquals("invalid",solution("AxAxAxAoBoBoB"));
    }

    public String solution(String sentence) {

        List<String> words = new ArrayList<>();

        char ch = ' ';

        while (sentence.length() > 0) {
            if (sentence.length() < 3) return "invalid";

            if (checkLetter(sentence, 0)) {
                ch = sentence.charAt(0);

                int eIdx = 0;
                for (int i = 1; i < sentence.length(); ++i) {
                    if (sentence.charAt(i) == ch) {
                        eIdx = i;
                        break;
                    }
                }

                if (eIdx == 0) return "invalid";
                words.add(sentence.substring(0, eIdx + 1));
                sentence = sentence.substring(eIdx + 1);
            } else {
                if (!checkLetter(sentence, 1)) return "invalid";
                ch = sentence.charAt(1);

                int eIdx = -1;
                for (int i = 2; i < sentence.length(); ++i) {
                    if (checkLetter(sentence, i)) {
                        eIdx = i;
                        if (sentence.charAt(eIdx) != ch) break;
                    }
                }
                if (eIdx == -1) return "invalid";

                while (eIdx >= 1) {
                    if (ch == sentence.charAt(eIdx)) break;
                    eIdx--;
                }

                words.add(sentence.substring(0, eIdx + 2));
                sentence = sentence.substring(eIdx + 2);
            }
        }

        String ans = "";
        for (String word : words) {
            ans += convertToString(word) + " ";
        }
        return ans.trim();

    }

    public String convertToString(String s){
        if(checkLetter(s,0)) s=s.replace(s.charAt(0),' ');
        if(checkLetter(s,1)) s=s.replace(s.charAt(1),' ');
        if(checkLetter(s,2)) s=s.replace(s.charAt(2),' ');
        s=s.replace(" ","");

        return s;
    }
    public boolean checkLetter(String str,int i){
        return str.charAt(i)>='a' && str.charAt(i)<='z';
    }

}
