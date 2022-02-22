package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 후보키 {

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(
                new String [][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                        {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}
        ));
    }

    static ArrayList<HashSet<Integer>> candidateKey;
    static String [][] table;
    static int length;
    static int answer;
    static public int solution(String [][] relation){
        answer=0;
        candidateKey=new ArrayList<>();
        table=relation;
        length=relation[0].length;
        for(int i=1;i<=length;++i){
            makeSet(-1,i,0,new HashSet<Integer>());
        }
        return answer;
    }

    private static void makeSet(int idx, int target, int count, HashSet<Integer> set){
        if(count==target){
            if(!isUnique(set)) return; // 유일성
            for(HashSet<Integer> key: candidateKey){ // 최소성
                if(set.containsAll(key)) return;
            }
            candidateKey.add(set);
            answer++;
        }

        for(int i=idx+1; i<length;++i){
            HashSet<Integer> newSet=new HashSet<>(set);
            newSet.add(i);
            makeSet(i,target,count+1,newSet);
        }
    }

    public static boolean isUnique(HashSet<Integer> set){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i< table.length;++i){
            String temp="";
            for (Integer index : set) {
                temp+=table[i][index];
            }
            if(!list.contains(temp)) list.add(temp);
            else return false;
        }
        return true;
    }

}
