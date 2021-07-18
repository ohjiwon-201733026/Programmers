package BaekJoon.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> notListen=new HashSet<>();
        ArrayList<String> ans=new ArrayList<>();

        for(int i=0;i<N;++i){
            String name=br.readLine();
            notListen.add(name);
        }
        int cnt=0;

        for(int i=0;i<M;++i){
            String name=br.readLine();
            if(notListen.contains(name)) { ans.add(name); }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(String s: ans) System.out.println(s);

    }
}
