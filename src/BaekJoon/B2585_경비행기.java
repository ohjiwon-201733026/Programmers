package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2585_경비행기 {
    static int n,k;
    static int [][] arr;
    static boolean [] check;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        arr=new int [n+1][2];
        for(int i=1;i<=n;++i){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        int first=0;
        int end=10000;
        int mid=0;
        int ans=0;

        while (first<=end){
            mid=(first+end)/2;
            if(bfs(mid,0,mid*10)){
                ans=mid;
                end=mid-1;
            }
            else{
                first=mid+1;
            }
        }
        System.out.println(ans);
    }

    public static boolean bfs(int mid, int start, int canDis){
        check=new boolean[n+1];
        int cnt=0;
        double dis=0;
        double disTo=0;
        int num=0;
        int size=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            size=q.size();
            if(cnt>k){
                return false;
            }

            for(int i=0;i<size;++i){
                num=q.poll();

                if(!check[num]){
                    check[num]=true;

                    for(int j=1;j<=n;++j){
                        dis=Math.sqrt(Math.pow(arr[num][0]-arr[j][0],2)+Math.pow(arr[num][1]-arr[j][1],2));
                        if(dis<=canDis){
                            disTo=Math.sqrt(Math.pow(10000-arr[j][0],2)+Math.pow(10000-arr[j][1],2));
                            if(disTo<=canDis) return true;
                        }
                        q.add(j);
                    }
                }

            }
            cnt++;
        }
        return false;
    }
}
