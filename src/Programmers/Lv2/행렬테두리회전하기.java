package Programmers.Lv2;

public class 행렬테두리회전하기 {
    public static void  main(String[] args) {
        int rows=6;
        int columns=6;
        int [][]queries={
                {2,2,5,4},
                {3,3,6,6},
//                {5,1,6,3}
        };
        int [] result=solution(rows, columns, queries);
        for(int a:result) System.out.println(a);

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int [queries.length];
        int [][] map=new int [rows+1][columns+1];

        for(int i=1;i<rows+1;++i){
            for(int j=1;j<columns+1;++j){
                map[i][j]=(i-1)*columns+j;
            }
        }
        int [][] ch=new int [rows+1][columns+1];
        for(int i=1;i<rows+1;++i){
            for(int j=1;j<columns+1;++j){
                ch[i][j]=map[i][j];
            }
        }
        for(int k=0;k<queries.length;++k){
            int [] q=queries[k];
            int x1=q[0],y1=q[1],x2=q[2],y2=q[3];
            int dx=x2-x1, dy=y2-y1;
            int min=Integer.MAX_VALUE;
            for(int i=1;i<rows+1;++i){
                for(int j=1;j<columns+1;++j){
                    map[i][j]=ch[i][j];
                }
            }
            for(int i=y1;i<y1+dy;i++) { ch[x1][i+1]=map[x1][i]; min=Math.min(map[x1][i],min);}
            for(int i=x1;i<x1+dx;++i) { ch[i+1][y2]=map[i][y2]; min=Math.min(map[i][y2],min);}
            for(int i=y1+1;i<=y1+dy;++i) { ch[x2][i-1]=map[x2][i]; min=Math.min(map[x2][i],min);}
            for(int i=x1+1;i<=x1+dx;++i)  {ch[i-1][y1]=map[i][y1]; min=Math.min(map[i][y1],min);}
            answer[k]=min;
        }

        for(int i=1;i<rows+1;++i){
            for(int j=1;j<columns+1;++j){
                System.out.print(ch[i][j]+" ");
            }
            System.out.println();
        }



        return answer;
    }
}
