package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1016_제곱ㄴㄴ수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long min=Long.valueOf(st.nextToken());
        long max=Long.valueOf(st.nextToken());

        int result=(int)(max-min+1);
        int sqrt=((int)Math.sqrt(max));

        boolean [] checks=new boolean[result]; // 제곱 ㄴㄴ가 아님을 체크, false
        long [] num=new long[result];

        for(long i=2;i<=sqrt;++i){
            long squared=i*i;
            long start=min%squared==0?min/squared:(min/squared)+1;
            for(long j=start;j*squared<=max;++j){
                checks[(int)((j*squared)-min)]=true;
            }
        }
        int count=0;
        for(int i=0;i<result;++i){
            if(!checks[i]) count++;
        }
        System.out.println(count);
    }

}
