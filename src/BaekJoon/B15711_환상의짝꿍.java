package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class B15711_환상의짝꿍 {
    static List<Integer> primeNumberList=new ArrayList<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        primeNumberList.add(2);
        addPrimeNumberList(2000001);
        int t=Integer.parseInt(br.readLine());

        for(int i=0;i<t;++i){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            long a=Long.parseLong(st.nextToken());
            long b=Long.parseLong(st.nextToken());
        }

    }





    public static void addPrimeNumberList(int number){
        for(int i=3;i<=number;i+=2){
            isDivided(i);
        }
    }

    private static void isDivided(int number) {
        int x=(int)Math.sqrt(number);
        for(Integer primeNumber: primeNumberList){
            if(primeNumber>x){
                primeNumberList.add(number);
                return;
            }
            if(number%primeNumber==0) return;
        }
    }
}
