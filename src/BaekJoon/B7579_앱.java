package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class B7579_앱 {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int appNum,needMemory;
       int [][] memoryList;
       int costMax=10000;

       int [] cost=new int [costMax+1];
       int answer=0;

       appNum=sc.nextInt();
       needMemory=sc.nextInt();

       memoryList=new int [2][appNum];
        Arrays.fill(cost,-1);
        cost[0]=0;

        for(int x=0;x<2;++x){
            for(int y=0;y<appNum;++y){
                memoryList[x][y]=sc.nextInt();
            }
        }

        for(int x=0;x<appNum;++x){
            for(int y=costMax;y>=memoryList[1][x];y--){
                if(cost[y-memoryList[1][x]]!=-1){
                    cost[y]=Math.max(cost[y],cost[y-memoryList[1][x]+memoryList[0][x]]);
                }
            }
        }
    }
}
