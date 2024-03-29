package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

    @Test
    public void test(){
        int [] answer={11, 1, 27, 15};
        int [] result=solution("KAKAO");
        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }

    public int [] solution(String msg){
        HashMap<String,Integer> dic=new HashMap<>();
        char a='A';
        for(int i=1;i<=26;++i){
            dic.put(a+"",i);
            a++;
        }
        int num=27;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<msg.length();++i){
            String s=msg.charAt(i)+"";
            while (dic.containsKey(s)){
                i++;
                if(msg.length()==i) break;
                s+=msg.charAt(i);
            }
            if(i==msg.length()){
                ans.add(dic.get(s));
                break;
            }

            ans.add(dic.get(s.substring(0,s.length()-1)));
            dic.put(s,num);
            num++;
            i--;

        }

        int [] answer=new int [ans.size()];
        for(int i=0;i<answer.length;++i){
            answer[i]=ans.get(i);
        }

        return answer;

    }
}
