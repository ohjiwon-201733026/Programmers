package Programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 모음사전 {

    @Test
    public void test(){
        Assertions.assertEquals(6,solution("AAAAE"));
        Assertions.assertEquals(10,solution("AAAE"));
        Assertions.assertEquals(1563,solution("I"));
        Assertions.assertEquals(1189,solution("EIO"));
    }
    static PriorityQueue<Node> dic;
    static ArrayList<Integer> list;
    static HashMap<Character,Integer> map;
    public int solution(String word){
        dic=new PriorityQueue<>();

        char [] arr={'A', 'E', 'I', 'O', 'U'};
        setMap();
        list=new ArrayList<>();

        for(int i=1;i<=5;++i){
            comb(arr,new char[i],5,0,i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length();++i){
            sb.append(map.get(word.charAt(i)));
        }
        for(int i=0;i<5-word.length();++i) sb.append('0');
        System.out.println(list.size());

        Collections.sort(list);
        return list.indexOf(Integer.parseInt(sb.toString()))+1;

//        int cnt=1;

//        while (!dic.isEmpty()){
//            if(dic.poll().s.equals(word)) break;
//            cnt++;
//        }
//
//        return cnt;
    }

    public void setMap(){
        map=new HashMap<>();
        map.put('A',1);
        map.put('E',2);
        map.put('I',3);
        map.put('O',4);
        map.put('U',5);
    }

    public void comb(char [] arr, char [] output, int n,int depth, int r){
        if(depth==r){
            StringBuilder sb=new StringBuilder();
            StringBuilder str=new StringBuilder();
            for(int i=0;i<r;++i){
                str.append(output[i]);
                sb.append(map.get(output[i]));
            }
            for(int i=0;i<5-r;++i) sb.append("0");
            dic.add(new Node(str.toString(),Integer.parseInt(sb.toString())));
            list.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i=0;i<arr.length;++i){
            output[depth]=arr[i];
            comb(arr,output,n,depth+1,r);
        }
    }

    class Node implements Comparable<Node>{
        String s;
        int num;

        public Node(String s, int num) {
            this.s = s;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "s='" + s + '\'' +
                    ", num=" + num +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.num-o.num;
        }
    }


}
