package BaekJoon;

import java.util.Scanner;

public class B8911_거북이 {

    public static int [] dx={0,0,-1,1};
    public static int [] dy={1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        
        while (tc-->0){
            int maxX=Integer.MIN_VALUE,maxY=Integer.MIN_VALUE,minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE;
            int curX=0;
            int curY=0;
            int dir=0;
            
            String op=sc.next();
            for (char c : op.toCharArray()) {
                maxX=Math.max(maxX,curX);
                maxY=Math.max(maxY,curY);
                minX=Math.min(minX,curX);
                minY=Math.min(minY,curY);

                if(c=='F'){
                    curX=curX+dx[dir];
                    curY=curY+dy[dir];
                    dir=dir;
                }
                if(c=='B'){
                    int changeDir=B(dir);
                    curX=curX+dx[changeDir];
                    curY=curY+dy[changeDir];
                }

                if(c=='L'){
                    dir=L(dir);
                }

                if(c=='R'){
                    dir=R(dir);
                }


            }

            maxX=Math.max(maxX,curX);
            maxY=Math.max(maxY,curY);
            minX=Math.min(minX,curX);
            minY=Math.min(minY,curY);
            sb.append((maxX-minX)*(maxY-minY)).append("\n");
        }

        System.out.println(sb.toString());
        

    }
    static int L(int dir){
        switch (dir){
            case 0: return 2;
            case 1: return 3;
            case 2: return 1;
            case 3: return 0;
        }
        return -1;
    }

    static int R(int dir){
        switch (dir){
            case 0: return 3;
            case 1: return 2;
            case 2: return 0;
            case 3: return 1;
        }

        return -1;
    }

    static int B(int curDir){
        if(curDir==0) return 1;
        if(curDir==1) return 0;
        if(curDir==2) return 3;
        if(curDir==3) return 2;

        return -1;
    }
}
