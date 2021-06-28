package study.week7;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

    public static void main(String[] args) {
        String msg="KAKAO";
        int [] ans=solution(msg);
        for(int n:ans) System.out.println(n);
    }

    private static int[] solution(String msg) {
        HashMap<String,Integer> dictionary=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        int idx=1;
        int cnt=26;
        for(char a='A';a<='Z';++a){
            dictionary.put(a+"",idx);
            idx++;
        }

        for(int i=0;i<msg.length();++i){
            String w=msg.charAt(i)+"";//K
            while(dictionary.containsKey(w)){
                i++;
                if(i==msg.length()){ // 마지막 idx 넘음 ( 마지막은 length()-1)
                    break;
                }
                w+=msg.charAt(i); // KA
            }

            if(i==msg.length()){
                list.add(dictionary.get(w));
                break;
            }

            list.add(dictionary.get(w.substring(0,w.length()-1))); //K:11
            dictionary.put(w,++cnt); // KA 27
            i--;

        }
       int [] answer=new int [list.size()];
        for(int j=0;j< list.size();++j) answer[j]=list.get(j);
        return answer;
    }
}
