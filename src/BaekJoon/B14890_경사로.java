package BaekJoon;

import java.util.Scanner;

public class B14890_경사로 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int [][] arr=new int [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                arr[i][j]=sc.nextInt();
            }
        }
        int answer=0;
        for(int i=0;i<n;++i){
            int pre=arr[i][0];
            boolean flag=true;
            boolean [] check=new boolean[n];
            for(int j=1;j<n;++j){
                if(pre==arr[i][j]) continue;
                if(Math.abs(pre-arr[i][j])>=2) { // 2 이상 차이 나는 경우
                    flag=false;
                    break;
                }
                if(pre-arr[i][j]==1){ // 내리막 경사로 왼쪽으로

                    int t=arr[i][j];
                    int cnt=0;
                    for(int k=j;k<j+l;++k){
                        if(k>=n){ break; }
                        if(t!=arr[i][k] || check[k]) { break; }
                        cnt++;
                    }
                    if(cnt==l){
                        for(int k=j;k<j+l;++k){
                            check[k]=true;
                        }
                    }
                    if(cnt!=l) {
                        flag=false;
                        break;
                    }
                    pre=t;
                }
                else if(arr[i][j]-pre==1){ // 오르막 경사 (오른쪽 체크)
                    int t=pre;
                    for(int k=j-l;k<j;++k){
                        if(k<0) {flag=false; break;}
                        if(t!=arr[i][k] || check[k]) { flag=false; break; }
                    }

                    if(flag){
                        for(int k=j-l;k<j;++k){
                            check[k]=true;
                        }
                    }
                    if(!flag) break;
                    pre=arr[i][j];
                }
            }
            if(flag) answer++;
        }


        for(int j=0;j<n;++j){
            int pre=arr[0][j];
            boolean flag=true;
            boolean [] check=new boolean[n];
            for(int i=0;i<n;++i){
                if(pre==arr[i][j]) continue;
                if(Math.abs(pre-arr[i][j])>=2) { // 2 이상 차이 나는 경우
                    flag=false;
                    break;
                }
                if(pre-arr[i][j]==1){ // 내리막 경사로 왼쪽으로
                    int t=arr[i][j];
                    for(int k=i;k<i+l;++k){
                        if(k>=n){ flag=false; break; }
                        if(t!=arr[k][j] || check[k]) { flag=false; break; }
                    }
                    if(flag){
                        for(int k=i;k<i+l;++k){
                            check[k]=true;
                        }
                    }
                    if(!flag) break;
                    pre=t;
                }
                else if(arr[i][j]-pre==1){ // 오르막 경사 (오른쪽 체크)
                    int t=pre;
                    for(int k=i-l;k<i;++k){
                        if(k<0) {flag=false; break;}
                        if(t!=arr[k][j] || check[k]) { flag=false; break; }
                    }

                    if(flag){
                        for(int k=i-l;k<i;++k){
                            check[k]=true;
                        }
                    }
                    if(!flag) break;
                    pre=arr[i][j];
                }
            }
            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
