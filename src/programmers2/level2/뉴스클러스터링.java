package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {


    @Test
    public void test(){
        Assertions.assertEquals(16384,solution("FRANCE","french"));
        Assertions.assertEquals(65536,solution("handshake","shake hands"));
        Assertions.assertEquals(43690,solution("aa1+aa2","AAAA12"));
        Assertions.assertEquals(65536,solution("E=M*C^2","e=m*c^2"));
    }

    public int solution(String str1, String str2){
        str1=str1.toLowerCase();

        str2=str2.toLowerCase();


        List<String > a=new ArrayList<>();
        List<String > b=new ArrayList<>();

        for(int i=0;i<str1.length()-1;++i) {
            String s=str1.substring(i,i+2);
            if(check(s)) a.add(s);
        }
        for(int i=0;i<str2.length()-1;++i) {
            String s=str2.substring(i,i+2);
            if(check(s)) b.add(s);
        }
        int aSize=a.size();
        int bSize=b.size();
        if(aSize==0 && bSize==0) return 65536;
        if(aSize==0 || bSize==0) return 0;
        System.out.println(aSize+" "+bSize);
        boolean [] visitedB=new boolean[b.size()];
        int cnt=0;
        for(int i=0;i<a.size();++i){
            String x=a.get(i);
            for(int j=0;j<b.size();++j){
                String y=b.get(j);
                if(x.equals(y) && !visitedB[j]){
                    visitedB[j]=true;
                    cnt++;
                    break;
                }
            }
        }
        int plus=aSize+bSize-cnt;
        double answer=(double)cnt/plus;
        System.out.println(cnt+" "+plus);

        return (int)(answer*65536);

    }

    public boolean check(String s){
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            if('a'<=c && c<='z') continue;
            return false;
        }
        return true;
    }
}
