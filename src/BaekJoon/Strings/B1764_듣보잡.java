package BaekJoon.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class B1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String [] arr=s.split(" ");
        int N=Integer.parseInt(arr[0]);
        int M=Integer.parseInt(arr[1]);

        ArrayList<String> notListen=new ArrayList<>();

        for(int i=0;i<N;++i){
            String name=br.readLine();
            notListen.add(name);
        }
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;++i){
            String name=br.readLine();
            if(notListen.contains(name)) { cnt++; sb.append(name+"\n"); }
        }
        String answer=cnt+"\n"+sb.toString();

        System.out.println(answer);


    }
}
