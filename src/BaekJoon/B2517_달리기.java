package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class B2517_달리기 {

    static class Player implements Comparable<Player>{
        int id,speed;

        public Player(int id, int speed) {
            this.id = id;
            this.speed = speed;
        }

        @Override
        public int compareTo(Player o) {
            return o.speed-this.speed;
        }
    }

    static int N,nn;
    static int [] indexedTree;
    static Player [] list;
    static int [] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());

        list=new Player[N+1];
        list[0]=new Player(0,0);

        for(int i=1;i<=N;++i){
            list[i]=new Player(i,Integer.parseInt(br.readLine()));
        }

        Arrays.sort(list);

        for(nn=1;nn<N;nn*=2);
        indexedTree=new int [nn*2+2];
        ans=new int [N+1];

    }
}
