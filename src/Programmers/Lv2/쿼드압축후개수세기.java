package Programmers.Lv2;

public class 쿼드압축후개수세기 {
    public static void main(String [] args){
        int [][] arr={{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int [] answer=solution(arr);
        System.out.println(answer[0]+" "+answer[1]);
    }
    public static int [][] map;
    public static int [] solution(int [][] arr){
        int [] answer=new int [2];
        int n= arr.length;
        map=arr;
        recur(0,0,n);
        for(int i=0;i<map.length;++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if(map[i][j]==0) answer[0]++;
                if(map[i][j]==1) answer[1]++;
            }
        }
        return answer;
    }

    public static void recur(int x, int y, int length){
        if(length==1) return;
        int flag=map[x][y];
        boolean check=true;
        for(int i=x;i<x+length;++i){
            for(int j=y;j<y+length;++j){

                if(flag!=map[i][j]) {
                    recur(x,y,length/2);
                    recur(x+length/2,y,length/2);
                    recur(x,y+length/2,length/2);
                    recur(x+length/2,y+length/2,length/2);
                    return;
                }
            }
        }
        for(int i=x;i<x+length;++i){
            for(int j=y;j<y+length;++j){
                map[i][j]=-1;
            }
        }
        map[x][y]=flag;
    }
}
