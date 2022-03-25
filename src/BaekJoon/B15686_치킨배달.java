package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B15686_치킨배달 {

    static int [][] map;
    static int n,m;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int answer;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        answer=Integer.MAX_VALUE;

        map=new int [n+1][n+1];

        house=new ArrayList<>();
        chicken=new ArrayList<>();

        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                map[i][j]=sc.nextInt();
            }
        }

        // 집 모으기
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                if(map[i][j]==1) house.add(new Point(i,j));
                if(map[i][j]==2) chicken.add(new Point(i,j));
            }
        }

        int x=chicken.size();
        // 치킨 집 x개 중 m개 고르기 (조합)
        for(int i=1;i<=m;++i){
            recur(new boolean[x],x,i,0);
        }

        System.out.println(answer);

    }

    public static void recur(boolean [] visited, int x, int r,int start){
        if(0==r){
            chicken_distance(visited);
            return;
        }

        for(int i=start;i<x;++i){
            if(!visited[i]){
                visited[i]=true;
                recur(visited,x,r-1,i+1);
                visited[i]=false;
            }
        }
    }

    public static void chicken_distance(boolean [] visited){
        int sum=0;
        for(int i=0;i<house.size();++i){
            Point h=house.get(i);
            int min=Integer.MAX_VALUE;
            for(int j=0;j<visited.length;++j){
                if(visited[j]){
                    Point c=chicken.get(j);
                    int num=Math.abs(h.r-c.r)+Math.abs(h.c-c.c);
                    min=Math.min(num,min);
                }
            }
            sum+=min;
            if(sum>answer) return;
        }

        answer=Math.min(sum,answer);
    }

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
