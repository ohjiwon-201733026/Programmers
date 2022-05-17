package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14891_톱니바퀴 {
    static String [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        arr=new String[4][8];

        for(int i=0;i<4;++i){
            arr[i]=br.readLine().split("");
        }

        int k=Integer.parseInt(br.readLine());
        while (k-->0){
            String [] s=br.readLine().split(" ");
            int num=Integer.parseInt(s[0])-1;
            int dir=Integer.parseInt(s[1]);
            int [] d=new int [4];
            d[num]=dir;

            boolean stop=false;
            for(int cur=num;cur>=1;--cur){
                int left=cur-1;
                if(stop) {
                    d[left]=0;
                    continue;
                }

                if(!arr[cur][6].equals(arr[left][2])) d[left]=d[cur]==1?-1:1; // 맞닿은 톱이 다름 -> 반대로 회전
                else {
                    d[left]=0; // 같으면 회전 안함
                    stop=true;
                }
            }

            stop=false;
            for(int cur=num;cur<3;++cur){
                int right=cur+1;
                if(stop) {
                    d[right]=d[cur];
                    continue;
                }
                if(!arr[cur][2].equals(arr[right][6])) d[right]=d[cur]==1?-1:1;
                else{
                    d[right]=0;
                    stop=true;
                }
            }

            for(int i=0;i<4;++i){
               if(d[i]==1) clockWise(i);
               else if (d[i]==-1) notClockWise(i);
            }



        }

        int answer=0;
        for(int i=0;i<4;++i){
            answer+=arr[i][0].equals("1")?Math.pow(2,i):0;
        }

        System.out.println(answer);


    }

    public static void clockWise(int i){
        String [] tmp=new String[8];
        for(int j=0;j<8;++j){
            tmp[(j+1)%8]=arr[i][j];
        }
        for(int j=0;j<8;++j){
            arr[i][j]=tmp[j];
        }
    }

    public static void notClockWise(int i){
        String [] tmp=new String[8];
        for(int j=0;j<8;++j){
            tmp[(j+7)%8]=arr[i][j];
        }
        for(int j=0;j<8;++j){
            arr[i][j]=tmp[j];
        }

    }
}
