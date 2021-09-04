package Programmers.Lv3;

public class 기둥과보설치 {
    public static void main(String [] args){
        int n=5;
        int [][] build_frame={
                {1,0,0,1},
                {1,1,1,1},
                {2,1,0,1},
                {2,2,1,1},
                {5,0,0,1},
                {5,1,0,1},
                {4,2,1,1},
                {3,2,1,1}
        };
        int [] result=solution(n,build_frame);
    }
    public static int [][] 보;
    public static int [][] 기둥;
    public static int N;
    public static int [] solution(int n, int [][] build_frame){
        // 가로 세로
        // 0 기둥, 1 보
        // 0 삭제, 1 설치
        N=n;
        보=new int [n][n];
        기둥=new int [n][n];
        for(int [] build:build_frame){
            int x=build[0];
            int y=build[1];
            int k=build[2]; // 설치 재료
            int l=build[3]; // 설치/ 삭제 여부

            if(l==1){ // 설치인 경우
                if(k==0){ // 기둥 설치
                    if(기둥설치가능(x,y)){
                        기둥[y][x]=1;
                    }
                }
                if(k==1){ // 보 설치
                    if(보설치가능(x,y)){
                        보[y][x]=1;
                    }
                }
            }
            else if(l==0){ // 삭제인 경우
                if(k==0){ // 기둥 삭제
                    if(기둥삭제가능(x,y)){
                        기둥[y][x]=0;
                    }
                }
            }
        }
    }

    public static boolean 기둥설치가능(int x, int y){
        if(y==0) return true;
        else if(x-1>=0 && (보[y][x]!=0 || 보[y][x-1]!=0)) return true;
        else if(y-1>=0 && 보[y-1][x]!=0) return true;
        else return false;
    }
    public static boolean 보설치가능(int x,int y){
        if(x+1<N && y-1>=0 && (기둥[y-1][x]==1 || 기둥[y-1][x+1]==1)) return true;
        else if(x-1>=0 && x+1<N && (보[y][x-1]==0 && 보[y][x+1]==0)) return true;
        return false;
    }
    public static boolean 기둥삭제(int x, int y){
        if(y+1<N && 기둥[y+1][x]==1){ // 기둥위에 기둥 있는 경우
            if(x-1>=0 && (보[y+1][x-1]==0 && 보[y+1][x]==0)) return false;
        }
        if(y+1<N && x+1<N && 보[y+1][x]!=0){
            if(기둥[y][x+1]==0) return false;
            else if()
        }
    }
}
