package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 위장 {

    public static void main(String[] args) {
        String [][] clothes={{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String [][] clothes){
        HashMap<String, ArrayList<String>> hm=new HashMap<>();

        for(int i=0;i<clothes.length;++i){
            String [] cloth=clothes[i];

            if(hm.containsKey(cloth[1])) hm.get(cloth[1]).add(cloth[0]);
            else {
                ArrayList<String> list=new ArrayList<>();
                list.add(cloth[0]);
                hm.put(cloth[1],list);
            }
        }

        int m=hm.size();
        int answer=0;
        int tmp=1;

        for(String cat:hm.keySet()){
            if(m==1) return answer=hm.get(cat).size();
            else{
                tmp*=(hm.get(cat).size()+1);
            }
        }
        return tmp-1;
    }
}
