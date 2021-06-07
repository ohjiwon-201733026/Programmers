package Programmers.Lv1;

import java.util.Arrays;

public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int [] arr=new int [n+1];
        Arrays.fill(arr,1);

        for(int i=0;i<lost.length;++i){ // 체육복 도난당한 학생 -1 (0)
            arr[lost[i]]--;
        }

        for(int i=0;i<reserve.length;++i){ // 체육복 여유있는 학생 +1(2)
            arr[reserve[i]]++;
        }

        for(int i=1;i<=n;++i){
            if(arr[i]==0){
                if(i-1>=1 && arr[i-1]==2) arr[i-1]=arr[i]=1;
                else if(i+1<=n && arr[i+1]==2) arr[i]=arr[i+1]=1;
            }
        }

        for(int i=1;i<=n;++i) {
            if (arr[i] == 0) answer--;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n=3;
        int [] lost={3};
        int [] reserve={1};
        int ans=solution(n,lost,reserve);
        System.out.println(ans);
    }
}
