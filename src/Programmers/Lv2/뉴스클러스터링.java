package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Locale;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        String str1="aa1+aa2";
        String str2="AAAA12";

//        System.out.println("++".matches("[^a-z]*"));

//        System.out.println(solution(str1,str2));
    }

    public static int solution(String s1, String s2){
        int answer=0;
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        ArrayList<String> s1Set=toSet(s1);
        ArrayList<String> s2Set=toSet(s2);
        if(s1Set.size()==0 && s2Set.size()==0) return 1;
        boolean [] check=new boolean[s2Set.size()];
        int cnt=0;
        for(int i=0;i<s1Set.size();++i){
            for(int j=0;j< s2Set.size();++j){
                if(s1Set.get(i).equals(s2Set.get(j)) && !check[j]){
                    check[j]=true;
                    cnt++;
                    break;
                }
            }
        }
        int num=s1Set.size()+s2Set.size()-cnt;

        answer=(int)(((double)cnt/num)*65536);

        return answer;
    }

    public static ArrayList<String> toSet(String s){
        ArrayList<String> set=new ArrayList<>();

        for(int i=0;i<s.length()-1;++i){
            String c=s.substring(i,i+2);
            if('a'<=c.charAt(0)&& c.charAt(0)<='z' && 'a'<=c.charAt(1)&& c.charAt(1)<='z') set.add(c);

        }

        return set;
    }
}
