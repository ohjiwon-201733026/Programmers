package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class 소수찾기 {

    @Test
    public void test(){
//        Assertions.assertEquals(3,solution("17"));
        Assertions.assertEquals(2,solution("011"));
    }
    public static HashSet<Integer> set=new HashSet<>();
    public int solution(String numbers){
        char [] arr=numbers.toCharArray();
        for(int i=1;i<=numbers.length();++i){
            boolean [] visited=new boolean[arr.length];
            char [] output=new char[arr.length];
            perm(arr,output,visited,0,arr.length,i);
        }
        int answer=0;
        for (Integer n : set) {
            if(isPrime(n)) answer++;
        }

        return answer;
    }

    public boolean isPrime(int n){
        if(n==1 || n==0) return false;
        for(int i=2;i<n;++i){
            if(n%i==0) return false;
        }
        return true;
    }

    private static void perm(char[] arr, char[] output, boolean[] visited, int depth, int n, int r) {
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
