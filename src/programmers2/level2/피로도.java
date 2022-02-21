package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 피로도 {

    @Test
    public void test(){
        Assertions.assertEquals(3,solution(80,new int [][]{{80,20},{50,40},{30,10}}));
    }
    int [][] d;
    int k;
    public int solution(int k, int [][] dungeons){
        d=dungeons;
        this.k=k;
        int [] arr= new int [dungeons.length];
        for(int i=0;i<dungeons.length;++i) arr[i]=i;

        boolean [] visited=new boolean[dungeons.length];
        perm(arr,visited,new int [dungeons.length],0,dungeons.length,dungeons.length);
        return answer;
    }
    int answer=0;
    public void perm(int [] arr, boolean [] visited, int [] output,int depth, int n, int r){
        if(depth==r){
            int cnt=check(output);
            answer=Math.max(answer,cnt);
            return;

        }

        for(int i=0;i<arr.length;++i){
            if(!visited[i]){
                output[depth]=arr[i];
                visited[i]=true;
                perm(arr,visited,output,depth+1,n,r);
                visited[i]=false;
            }
        }
    }

    public int check(int [] output){
        int cnt=0;
        int tmp=k;
        for (int i : output) {
            int [] a=d[i];
            if(tmp>=a[0]){
                if(tmp-a[1]>=0) {
                    cnt++;
                    tmp-=a[1];
                    continue;
                }
                else break;
            }
            else break;
        }
        return cnt;
    }
}
