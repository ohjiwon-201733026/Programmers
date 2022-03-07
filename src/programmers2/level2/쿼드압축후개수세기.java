package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 쿼드압축후개수세기 {

    @Test
    public void test(){
        int [] answer={4,9};
        int [] result=solution(new int [][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }

    }

    static int [][] arr;
    static int [][] check;
    public int [] solution(int [][] arr){
        this.arr=arr;
        int n=arr.length;
        check=new int [n][n];

        dfs(0,0,n);

        int a=0,b=0;

        for(int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                if(check[i][j]==-1) continue;
                if(check[i][j]==0) a++;
                else b++;
            }
        }

        return new int []{a,b};

    }

    public void dfs(int x, int y,int n){
        if(n<=1) {
            check[x][y]=arr[x][y];
            return;
        }

        int piv=arr[x][y];
        for(int i=x;i<x+n;++i){
            for(int j=y;j<y+n;++j){
                if(piv!=arr[i][j]){
                    dfs(x,y,n/2);
                    dfs(x+n/2,y,n/2);
                    dfs(x,y+n/2,n/2);
                    dfs(x+n/2,y+n/2,n/2);
                    return;
                }
            }
        }
            System.out.println(x+" "+y+" "+n);
            for(int i=x;i<x+n;++i){
                for(int j=y;j<y+n;++j){
                    check[i][j]=-1;
                }
            }
            check[x][y]=arr[x][y];


    }
}
