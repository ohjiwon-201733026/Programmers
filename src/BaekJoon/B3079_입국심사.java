package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B3079_입국심사 {
    static long N,M,max;
    static int time[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Long.parseLong(st.nextToken());
        M=Long.parseLong(st.nextToken());
        max=0;
        time=new int [(int)N];

        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            max=Math.max(time[i],max);
        }
        Arrays.sort(time);
        binarySearch();
    }

    public static void binarySearch(){
        long left, right, mid, sum;
        left=1;
        right=max*M;
        long answer=0;
        while (left<=right){
            sum=0;
            mid=(left+right)/2;
            for(int i=0;i<N;++i){
                sum+=mid/time[i];
            }
            if(sum>=M) right=mid-1;
            else {
                answer=mid;
                left=mid+1;

            }
        }
        System.out.println(left);
    }
}
