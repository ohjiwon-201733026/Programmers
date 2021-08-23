package Programmers.Lv3;

import java.util.ArrayList;
import java.util.List;

public class 브라이언의고민 {

    public static void main(String [] args){
        String sentence="HaEaLaLaObWORLDb";
        System.out.println(solution(sentence));
    }
    public static List<Integer> pos;
    public static List<String> words=new ArrayList<>();

    public static String solution(String sentence){
        StringBuilder sb=new StringBuilder();
        char ch=' ';
        while(sentence.length()>0){
            if(sentence.length()<3) return "invalid";
            if(isLowerCase(sentence.charAt(0))){ // 2규칙
                ch=sentence.charAt(0);

                int eIdx=0;
                for(int i=1;i<sentence.length();++i){
                    if(sentence.charAt(i)==ch) {
                        eIdx=i;
                        break;
                    }
                }
                if(eIdx==0) return "invalid";
                words.add(sentence.substring(0,eIdx+1));
                sentence=sentence.substring(eIdx+1);

            }
            else{

                if(!isLowerCase(sentence.charAt(1))) return "invalid";
                ch=sentence.charAt(1);

                int eIdx=-1;
                for(int i=2;i<sentence.length();++i){
                    if(isLowerCase(sentence.charAt(i))){
                        eIdx=i;
                        if(sentence.charAt(eIdx)!=ch) break;
                    }
                }
                if(eIdx==-1) return "invalid";

                while(eIdx>=1){
                    if(ch==sentence.charAt(eIdx)) break;
                    eIdx--;
                }

                words.add(sentence.substring(0,eIdx+2));
                sentence=sentence.substring(eIdx+2);
            }
        }

        String ans="";
        for(String s:words){
            ans+=convertToString(s)+" ";
        }

        return ans.trim();

    }

    private static String convertToString(String s){
        if(isLowerCase(s.charAt(0))) s=s.replace(s.charAt(0),' ');
        if(isLowerCase(s.charAt(1))) s=s.replace(s.charAt(1),' ');
        if(isLowerCase(s.charAt(2))) s=s.replace(s.charAt(2),' ');
        s=s.replace(" ","");

        return s;
    }

    public static boolean isLowerCase(char c){
        if('a'<=c && c<='z') return true;
        else return false;
    }
}
