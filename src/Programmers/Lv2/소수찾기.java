package Programmers.Lv2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;

public class 소수찾기 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution("17"));
//        Assertions.assertEquals(2,solution("011"));
    }

    static HashSet<Integer> set=new HashSet<>();
    public int solution(String numbers){

        String [] arr=numbers.split("");

        for(int i=1;i<=numbers.length();++i){
            perm(arr,new String[arr.length],new boolean[arr.length],0,arr.length,i);
        }

        System.out.println(set);
        int answer=0;
        for (int s : set) {
            if(prime(s)) {
                answer++;
            }
        }


        return answer;

    }

    private static boolean prime(int n){
        if(n==1 || n==0) return false;
        for(int i=2;i<n;++i){
            if(n%i==0) return false;
        }

        return true;
    }
    private static void perm(String [] arr, String [] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < r; ++i) {
                sb.append(output[i]);
            }
            set.add(Integer.parseInt(sb.toString()));

            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]==true){
                visited[i]=true;
                output[depth]=arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }


    }
}
