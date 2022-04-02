package BaekJoon;

import java.util.*;

public class B2667_단지번호붙이기 {
    static int n;
    static int [][] arr;
    static boolean [][] visited;
    static int [] dx={0,1,0,-1};
    static int [] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        arr=new int [n][n];
        visited=new boolean[n][n];

        for(int i=0;i<n;++i){
            String s=sc.next();
            for(int j=0;j<n;++j){
                arr[i][j]=s.charAt(j)-'0';
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        int cnt=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(arr[i][j]==1 && !visited[i][j]){
                    cnt++;
                    int num=bfs(cnt,i,j);
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt-1);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static int bfs(int cnt, int i, int j){
        int num=0;
        Queue<int [] >q=new LinkedList<>();
        q.add(new int []{i,j});
        visited[i][j]=true;
        arr[i][j]=cnt;
        num++;

        while (!q.isEmpty()){
            int [] cur=q.poll();

            for(int k=0;k<4;++k){
                int x=cur[0]+dx[k];
                int y=cur[1]+dy[k];

                if(0<=x && x<n && 0<=y && y<n){
                    if(!visited[x][y] && arr[x][y]==1){
                        num++;
                        arr[x][y]=cnt;
                        visited[x][y]=true;
                        q.add(new int []{x,y});
                    }
                }
            }
        }

        return num;
    }
}
