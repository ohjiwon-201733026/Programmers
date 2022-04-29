package BaekJoon.삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3190_뱀 {

    static int n,d=0;
    static int [][] map;
    static Map<Integer,String> moveInfo;
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1,0,-1};
    static Queue<Integer> snake;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int K=sc.nextInt();
        snake=new LinkedList<>();
        map=new int [n][n];
        moveInfo=new HashMap<>();

        while (K-->0){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            map[x][y]=1;
        }

        int l=sc.nextInt();
        while (l-->0){
            int sec=Integer.parseInt(sc.next());
            String dir=sc.next();
            moveInfo.put(sec,dir);
        }

        System.out.println(move());

    }

    static int move(){
        int sec=0;
        snake.add(0);
        int px=0;int py=0;

        while (true){
            int nx=px+dx[d];
            int ny=py+dy[d];
            sec++;

            if(snake.contains(ny*n+nx)) break;
            if(nx<0 || nx>n-1 || ny<0 || ny>n-1) break;

            if(map[ny][nx]==1){
                map[ny][nx]=0;
                snake.add(ny*n+nx);
            }
            else{
                snake.add(ny*n+nx);
                snake.poll();
            }

            if(moveInfo.containsKey(sec)){
                String data=moveInfo.get(sec);
                if(data.equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                }
                else{
                    d-=1;
                    if(d==-1) d=3;
                }
            }

            px=nx;
            py=ny;
        }

        return sec;

    }


}
