package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B2261_가장가까운두점 {
    private static Point [] p;

    private static class Point{
        int x,y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    private static int dist(Point o1, Point o2){
        return (o1.x-o2.x)*(o1.x-o2.x)+(o1.y-o2.y)*(o1.y-o2.y);
    }

    private static int brute(int start, int end){
        int minDist=Integer.MAX_VALUE;

        for(int i=start;i<end;++i){
            for(int j=i+1;j<=end;++j){
                minDist=Math.min(minDist,dist(p[i],p[j]));
            }
        }
        return minDist;
    }

    private static int closest(int start, int end){
        if(end-start+1<4){
            return brute(start,end);
        }

        int mid=(start+end)/2;

        int left=closest(start,mid);
        int right=closest(mid+1,end);

        int minDist=Math.min(left,right);
        return minDist;

    }
}
