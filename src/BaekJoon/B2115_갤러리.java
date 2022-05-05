package BaekJoon;

import java.util.Scanner;

public class B2115_갤러리 {

    static char [][][] picture={{{'X','X'},{'.','.'}},{{'.','.'},{'X','X'}}, {{'X','.'},{'X','.'}}, {{'.','X'},{'.','X'}}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        char [][] map=new char[m][n];
        boolean [][][] visited=new boolean[m][n][4];

        for(int i=0;i<m;++i){
            String s=sc.next();
            for (int j=0;j<n;++j){
                map[i][j]=s.charAt(j);
            }
        }
        int answer=0;
        for(int k=0;k<4;++k) {
            for (int i = 0; i < m - 1; ++i) {
                for (int j = 0; j < n - 1; ++j) {
                    if (picture[k][0][0]==map[i][j] && picture[k][0][1]==map[i][j+1]
                    && picture[k][1][0]==map[i+1][j] && picture[k][1][1]==map[i+1][j+1] ){
                        if(k==0){
                            if(!visited[i][j][k] && !visited[i][j+1][k]){
                                answer++;
                                visited[i][j][k]=true;
                                visited[i][j+1][k]=true;
                            }
                        }

                        if(k==1){
                            if(!visited[i+1][j][k] && !visited[i+1][j+1][k]){
                                answer++;
                                visited[i+1][j][k]=true;
                                visited[i+1][j+1][k]=true;
                            }
                        }

                        if(k==2){
                            if(!visited[i][j][k] && !visited[i+1][j][k]){
                                answer++;
                                visited[i][j][k]=true;
                                visited[i+1][j][k]=true;
                            }
                        }

                        if(k==3){
                            if(!visited[i][j+1][k] && !visited[i+1][j+1][k]){
                                answer++;
                                visited[i][j+1][k]=true;
                                visited[i+1][j+1][k]=true;
                            }
                        }

                    }
                }
            }
        }

        System.out.println(answer);



    }
}
