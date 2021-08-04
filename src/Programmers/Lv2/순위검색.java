package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 순위검색 {
    public static int [][] arr={{1,1,1,1},{0,1,1,1},{1,0,1,1},{1,1,0,1},{1,1,1,0},{0,0,1,1},{0,1,0,1},{0,1,1,0},
            {1,0,0,1},{1,0,1,0},{1,1,0,0},{0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0},{0,0,0,0}};
    public static HashMap<Integer, ArrayList<String>> idx;
    public static int [] score;
    public static void main(String[] args) {
        String [] info={"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String [] query={"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        int [] answer=solution(info,query);

        for(int n:answer) System.out.println(n);

    }
    public static void comb(int j,String info){

        idx.put(j,new ArrayList<>());
        String [] t=info.split(" ");
        score[j]=Integer.parseInt(t[4]);
        for(int i=0;i<arr.length;++i){
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<4;++k){
                if(arr[i][k]==0) sb.append("-");
                else sb.append(t[k]);
            }
            idx.get(j).add(sb.toString());
        }
    }

    public static int [] solution(String [] info, String [] query){
        int [] answer=new int [query.length];
        score=new int [info.length];
        idx=new HashMap<>();
        for(int i=0;i< info.length;++i) comb(i,info[i]);

        // query
        for(int i=0;i< query.length;++i){
            String s=query[i].replaceAll(" and ","");
            String [] tmp=s.split(" ");
            int scr=Integer.parseInt(tmp[1]);
            String key=tmp[0];
            int cnt=0;
            for(int j=0;j< info.length;++j){
                if(score[j]>=scr){
                    if(idx.get(j).contains(key)) cnt++;
                }
            }

            answer[i]=cnt;

        }
//        for(int key:idx.keySet()){
//            System.out.println(key+" "+idx.get(key).size());
//
//        }

        return answer;
    }
}
