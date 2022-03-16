package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2638_치즈 {
    public static int n,m;
    public static int [][] map;
    public static boolean [][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new int [n][m];
        visited=new boolean [n][m];
        sum=new int [n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                map[i][j]=sc.nextInt();
            }
        }
        int x=0,y=0;
        loop:
        while (true){
            for(int i=0;i<n;++i){
                if(map[i][0]==0) {
                    x=i;y=0;break loop;
                }
                if(map[i][m-1]==0){
                    x=i;y=m-1;
                    break loop;
                }
            }
            for(int j=0;j<m;++j){
                if(map[0][j]==0){
                    x=0;y=j;break loop;
                }
                if(map[n-1][j]==0){
                    x=n-1;y=j;
                    break loop;
                }
            }
        }

        int answer=0;
        while (true){
            if(cheezeNotExist()) break;
            sum=new int[n][m];
            visited=new boolean[n][m];
            dfs(x,y);
            meltCheeze();
            answer++;

        }
        System.out.println(answer);



    }

    public static  boolean cheezeNotExist(){
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(map[i][j]==1) return false;
            }
        }
        return true;
    }

    public static void meltCheeze(){
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(sum[i][j]>=2) map[i][j]=0;
            }
        }
    }
    static int [][] sum;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void dfs(int x, int y){
        Queue<int []> q=new LinkedList<>();
        q.add(new int []{x,y});

        while (!q.isEmpty()){
            int [] cur=q.poll();

            if(!visited[cur[0]][cur[1]] && map[cur[0]][cur[1]]==0){
                for(int k=0;k<4;++k){
                    int i=cur[0]+dx[k];
                    int j=cur[1]+dy[k];

                    if(i<0 || i>=n || j<0 || j>=m) continue;

                    if(map[i][j]==1){
                        sum[i][j]++;

                    }
                    else{
                        q.add(new int []{i,j});
                    }
                }
            }



            visited[cur[0]][cur[1]]=true;
        }
    }

}
