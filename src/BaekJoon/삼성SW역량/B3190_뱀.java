package BaekJoon.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3190_뱀 {
    static int n,k,d=0;
    static int [][] apple;
    static HashMap<Integer,String> map;
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        apple=new int [n][n];
        map=new HashMap<>();

        while (k-->0){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            apple[x][y]=1;
        }

        int l=sc.nextInt();
        while (l-->0){
            int x=sc.nextInt();
            String y=sc.next();
            map.put(x,y);
        }

        d=0;

        System.out.println(dfs());

    }
    static int dfs(){
        Queue<Integer> q=new LinkedList<>();
        int px=0;
        int py=0;
        q.add(0);

        int time=0;
        while (true){
            int nx=px+dx[d];
            int ny=py+dy[d];
            time++;

            if(nx<0 || nx>n-1 || ny<0 || ny>n-1) break;

            if(q.contains(ny*n+nx)) break;

            if(apple[ny][nx]==1){
                q.add(ny*n+nx);
                apple[ny][nx]=0;
            }
            else if(apple[ny][nx]==0){
                q.add(ny*n+nx);
                q.poll();
            }

            if(map.containsKey(time)) {
                if (map.get(time).equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }

            px=nx;
            py=ny;

        }

        return time;
    }


}
