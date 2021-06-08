package study.week5;

import java.util.ArrayList;

public class 영어끝말잇기 {

    public static void main(String[] args) {
        int n=2;
        String [] words={"hello", "one", "even", "never", "now", "world", "draw"};
        int [] answer=solution(n,words);
        System.out.println(answer[0]+" "+answer[1]);
    }

    private static int[] solution(int n, String[] words) {
        int [] answer =new int [2];
        ArrayList<String> list=new ArrayList<>();
        list.add(words[0]);
        char pre =words[0].charAt(words[0].length()-1);
        int index=-1;
        for(int i=1;i< words.length;++i){
            String word=words[i];
            // 앞 문자열의 맨 뒤 글자 != 뒤 문자열의 맨 앞 글자 && 이미 나온 문자열일 경우
            if(pre!=word.charAt(0) || list.contains(word)) {
                index=i;
                break;
            }
            else {
                list.add(word);
                pre=word.charAt(word.length()-1);
            }
        }

        if(index==-1) return answer;
        else{
            answer[0]=(index+1)%n==0?n:(index+1)%n;
            answer[1]=(index+1)%n==0?(index+1)/n:(index+1)/n+1;
        }

        return answer;
    }
}
