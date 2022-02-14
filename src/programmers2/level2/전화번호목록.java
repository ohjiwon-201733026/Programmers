package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class 전화번호목록 {

    @Test
    public void test(){
        Assertions.assertEquals(false,solution(new String []{"119", "97674223", "1195524421"}));
        Assertions.assertEquals(true,solution(new String []{"123","456","789"}));
        Assertions.assertEquals(false,solution(new String []{"12","123","1235","567","88"}));
    }


    public boolean solution(String [] phone_book){
        HashSet<String> set=new HashSet<>();
        for (String s : phone_book) {
            set.add(s);
        }


        for(int i=0;i<phone_book.length;++i){
            String piv=phone_book[i];
            for(int j=0;j<piv.length();++j){
                if(set.contains(piv.substring(0,j))) return false;
            }
        }
        return true;
    }
}
