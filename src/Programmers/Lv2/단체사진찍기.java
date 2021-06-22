package Programmers.Lv2;

import java.util.HashMap;

public class 단체사진찍기 {

    public static void main(String[] args) {
        int n=2;
        String [] data={"N~F=0", "R~T>2"};
        int answer=solution(n,data);
        System.out.println(answer);
    }

    static int [] position;
    static boolean [] visited;
    static int cnt;
    static HashMap<Character,Integer> kakao;
    static boolean ok;

    private static int solution(int n,String[] data) {
        int answer=0;
        position=new int [8];
        visited=new boolean[8];
        cnt=0;
        kakao=new HashMap<>();
        ok=true;

        kakao.put('A',0);
        kakao.put('C',1);
        kakao.put('F',2);
        kakao.put('J',3);
        kakao.put('M',4);
        kakao.put('N',5);
        kakao.put('R',6);
        kakao.put('T',7);

        perm(0,data);
        answer=cnt;
        return answer;
    }

    private static void perm(int idx, String[] data) {

        if(idx==8){
            if(isOk(data)) cnt++;
            return;
        }

        for(int i=0;i<8;++i){
            if(!visited[i]){
                visited[i]=true;
                position[idx]=i;
                perm(idx+1,data);
                visited[i]=false;
            }
        }
    }

    public static boolean isOk(String [] data){

        for(int i=0;i<data.length;++i){
            int X=kakao.get(data[i].charAt(0));
            int Y=kakao.get(data[i].charAt(2));
            char type=data[i].charAt(3);
            int diff=data[i].charAt(4)-'0';
            int xPos=position[X];
            int yPos=position[Y];

            if(type=='='){
                if(Math.abs(xPos-yPos)-1!=diff) return false;
                if(Math.abs(xPos-yPos)-1<=diff) return false;
                if(Math.abs(xPos-yPos)-1>=diff) return false;
            }
        }
        return true;
    }
}
