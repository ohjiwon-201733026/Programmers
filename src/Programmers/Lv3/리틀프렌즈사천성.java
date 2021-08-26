package Programmers.Lv3;


import java.util.ArrayList;
import java.util.Collections;

public class 리틀프렌즈사천성 {
    public static void main(String [] args){
        int m=3;
        int n=3;
        String [] board={"DBA", "C*A", "CDB"};
        System.out.println(solution(m,n,board));
    }
    static ArrayList<Tile> list;
    static int M,N;
    static char [][] b;
    public static String solution(int m, int n, String[] board){
        M=m;
        N=n;
        b=new char[m][n];
        for(int i=0;i< board.length;++i){
            b[i]=board[i].toCharArray();
        }
        initArrayList(b);

        StringBuilder sb=new StringBuilder();

        int i=0;
        loop:
        for(i=0;i<list.size();i+=2){
            Tile t1=list.get(i);
            Tile t2=list.get(i+1);
            if(canRemove(t1,t2)){
                sb.append(t1.c);
                list.remove(i);
                list.remove(i);
                b[t1.x][t1.y]='.';
                b[t2.x][t2.y]='.';
                i-=2;
                continue loop;
            }
        }
        return i==0?sb.toString():"IMPOSSIBLE";
    }

    private static boolean canRemove(Tile t1, Tile t2){
        if(t1.x==t2.x){
            for(int i=t1.y+1;i<=t2.y-1;++i){
                if(b[t1.x][i]!='.') return false;
            }
            return true;
        }
        else if(t1.y==t2.y){
            for(int i=t1.x+1;i<=t2.x-1;++i){
                if(b[i][t1.y]!='.') return false;
            }
            return true;
        }
        else{
            boolean check1=true, check2=true;

            if(t1.x<t2.x){
                for(int i=t1.y+1;i<=t2.y;++i){
                    if(b[t1.x][i]!='.'){
                        check1=false;
                        break;
                    }
                }

                for(int i=t1.x+1;i<=t2.x-1;++i){
                    if(!check1) break;
                    if(b[i][t2.y]!='.'){
                        check1=false;
                        break;
                    }
                }

                // down -> right
                for(int i=t1.x+1;i<=t2.x;++i){
                    if(b[i][t1.y]!='.'){
                        check2=false;
                        break;
                    }
                }
                for(int i=t1.y+1;i<=t2.y-1;++i){
                    if(!check2) break;
                    if(b[t2.x][i]!='.'){
                        check2=false;
                        break;
                    }
                }
            }
            else{
                for(int i=t1.y+1;i<=t2.y;++i){
                    if(b[t1.x][i]!='.'){
                        check1=false;
                        break;
                    }
                }
                for(int i=t1.x;i>=t2.x+1;--i){
                    if(!check1) break;
                    if(b[i][t2.y]!='.'){
                        check1=false;
                        break;
                    }
                }

                for(int i=t1.x-1;i>=t2.x;--i){
                    if(b[i][t1.y]!='.'){
                        check2=false;
                        break;
                    }
                }
                for(int i=t1.y+1;i<=t2.y-1;++i){
                    if(!check2) break;
                    if(b[t2.x][i]!='.'){
                        check2=false;
                        break;
                    }
                }
            }

            if(check1 || check2) return true;
            else return false;
        }


    }

    private static void initArrayList(char [][] b){
        list=new ArrayList<>();

        for(int i=0;i<M;++i){
            for(int j=0;j<N;++j){
                char c= b[i][j];
                if(Character.isUpperCase(c)){
                    list.add(new Tile(c,i,j));
                }
            }
        }

        //
        Collections.sort(list,((o1,o2)->{
            if(o1.c==o2.c){
                if(o1.x==o2.x){
                    return Integer.compare(o1.y,o2.y);
                }else if(o1.y==o2.y){
                    return Integer.compare(o1.x,o2.x);
                }
            }
            return Character.compare(o1.c,o2.c);
        }));
    }

    private static class Tile{
        char c;
        int x,y;

        Tile(char c, int x, int y){
            this.c=c;
            this.x=x;
            this.y=y;
        }
    }
}
