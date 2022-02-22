package programmers2.level3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 자물쇠와열쇠 {

    @Test
    public void test(){
        Assertions.assertEquals(true,solution(new int [][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                new int [][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
    static int [][] arr;
    static int n,m;
    public boolean solution(int [][] key, int [][] lock){
        m=key.length;
        n= lock.length;

        arr=new int[n+2*m-2][n+2*m-2];

        for(int k=0;k<4;++k) {
            key=rotate(key);
            for (int i = 0; i < m + n - 1; ++i) {
                for (int j = 0; j < m + n - 1; ++j) {
                    if(check(key,lock,i,j)) return true;

                }
            }
        }

        return true;
    }

    public boolean check(int [][] key, int [][] lock,int i,int j){
        int [][] tmp=new int [n+2*m-2][n+2*m-2];

        for(int x=i;x<i+m;++x){
            for(int y=j;y<j+m;++y){
                tmp[x][y]+=key[x-i][y-j];
            }
        }

        for(int x=0;x<lock.length;++x){
            for(int y=0;y< lock.length;++y){
                tmp[x+m-1][y+m-1]+=lock[x][y];
            }
        }

        for(int x=0;x<tmp.length;++x){
            for(int y=0;y<tmp.length;++y){
                System.out.print(tmp[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println("=======================");

        for(int x=m-1;x<m+n-1;++x){
            for(int y=m-1;y<m+n-1;++y){
                if(tmp[x][y]==0 || tmp[x][y]>=2) return false;
            }
        }


        return true;
    }

    public int [][] rotate(int [][] key){
        int n=key.length-1;
        int [][] tmp=new int [key.length][key.length];

        for(int i=0;i<key.length;++i){
            int [] t=key[i];
            for(int j=0;j< key.length;++j){
                tmp[j][n-i]=t[j];
            }
        }

        return tmp;
    }
}
