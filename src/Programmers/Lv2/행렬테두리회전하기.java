package Programmers.Lv2;

public class 행렬테두리회전하기 {
    public static void  main(String[] args) {
        int rows=6;
        int columns=6;
        int [][]queries={
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        };
        int [] result=solution(rows, columns, queries);
        for(int a:result) System.out.println(a);

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
       int [] answer=new int [queries.length];
       int [][] map=new int [rows+1][columns+1];
        // map 채우기
       for(int i=1;i<=rows;++i){
           for(int j=1;j<=columns;++j){
               map[i][j]=(i-1)*columns+j;
           }
       }
        int [][] change=new int [rows+1][columns+1];
        for(int i=1;i<=rows;++i){
            for(int j=1;j<=columns;++j){
                change[i][j]=map[i][j];
            }
        }

       for(int k=0;k< queries.length;++k){
           
           // 복사
           for(int i=1;i<=rows;++i){
               for(int j=1;j<=columns;++j){
                   map[i][j]=change[i][j];
               }
           }

           // 옮기기
           int x1=queries[k][1],y1=queries[k][0],x2=queries[k][3],y2=queries[k][2];
           int min=Integer.MAX_VALUE;
           for(int i=x1;i<x2;++i){ change[y1][i+1]=map[y1][i]; min=Math.min(min,map[y1][i]);}
           for(int i=y1;i<y2;++i){ change[i+1][x2]=map[i][x2]; min=Math.min(min,map[i][x2]);}
           for(int i=x2;i>x1;--i){ change[y2][i-1]=map[y2][i]; min=Math.min(min,map[y2][i]);}
           for(int i=y2;i>y1;--i){ change[i-1][x1]=map[i][x1]; min=Math.min(min,map[i-1][x1]);}

           answer[k]=min;

           for(int i=1;i<=rows;++i){
               for(int j=1;j<=columns;++j){
                   System.out.print(change[i][j]+" ");
               }
               System.out.println();
           }
       }
       return answer;
    }
}
