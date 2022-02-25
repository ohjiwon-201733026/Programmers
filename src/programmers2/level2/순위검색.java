package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 순위검색 {

    @Test
    public void test() {
        int[] result = solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
        int[] answer = {1, 1, 1, 1, 2, 4};

        for (int i = 0; i < result.length; ++i) {
            Assertions.assertEquals(result[i], answer[i]);
        }
    }

    static int [] answer;
    static HashMap<String,ArrayList<Integer>> map=new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
      answer=new int[query.length];
      setInfo(info);
      makeAnswer(query);
      return answer;
    }

    public static void makeAnswer(String [] query){

        for(int i=0;i< query.length;++i){
            String q=query[i].replaceAll(" and ","");
            String [] tmp=q.split(" ");
            String key=tmp[0];
            int score=Integer.parseInt(tmp[1]);

            answer[i]=counting(key,score);
        }

    }

    public static int counting(String key, int score){
        if(!map.containsKey(key)) return 0;
        ArrayList<Integer> list=map.get(key);
        int left=0,right=list.size()-1;

        while (left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)<score) left=mid+1;
            else right=mid-1;

        }

        return list.size()-left;
    }

    public static void setInfo(String [] info){
        for(int i=0;i<info.length;++i) dfs("",0,info[i].split(" "));
        Iterator<String> it= map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            List<Integer> li=map.get(key);
            Collections.sort(li);
        }
    }

    public static void dfs(String str, int depth, String [] info){
        if(depth==4){
            if(map.containsKey(str)) map.get(str).add(Integer.parseInt(info[4]));
            else{
                ArrayList<Integer> tmp=new ArrayList<>();
                tmp.add(Integer.parseInt(info[4]));
                map.put(str,tmp);
            }
            return;
        }

        dfs(str+"-",depth+1,info);
        dfs(str+info[depth],depth+1,info);
    }
}

