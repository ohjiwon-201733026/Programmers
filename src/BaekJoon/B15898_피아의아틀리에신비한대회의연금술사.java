package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B15898_피아의아틀리에신비한대회의연금술사 {

    static int [][][] 효능;
    static String [][][] 원소;
    static ArrayList<int[]> list;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list=new ArrayList<>();
        ans=0;

        효능 = new int[n][4][4];
        원소 = new String[n][4][4];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    효능[i][j][k] = sc.nextInt();
                }
            }

            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    원소[i][j][k] = sc.next();
                }
            }
        }

        int [] arr=new int [n];
        for(int i=0;i<n;++i) arr[i]=i;
        perm(arr,new int [3],new boolean[n],0,n,3);

        int [][] num=new int [5][5];
        String [][] str=new String[5][5];
        for(int i=0;i<5;++i){
            for(int j=0;j<5;++j){
                str[i][j]="W";
            }
        }

        for (int[] output : list) {
            dfs(output,0,num,str);
        }

        System.out.println(ans);
    }

    static void dfs(int [] output,int depth,int [][] num, String [][] str){
        if(depth==3){
            ans=Math.max(ans,calc(num,str));
            return;
        }

        for(int i=0;i<4;++i){
            효능[output[depth]]=rotate(효능[output[depth]]);
            원소[output[depth]]=roateS(원소[output[depth]]);

            int [][] mapN=copyN(num);
            String [][] mapS=copyS(str);
            for(int j=0;j<4;++j){
                    num=sumN(j,mapN,효능[output[depth]]);
                    str=sumS(j,mapS,원소[output[depth]]);
                    dfs(output,depth+1,num,str);
            }
        }


    }

    static String[][] sumS(int idx, String [][] mapN, String [][] tmpN){ // map(5), tmp(4)
        if(idx==0){
            for(int i=0;i<4;++i){
                for(int j=0;j<4;++j){
                    mapN[i][j]=tmpN[i][j];
                }
            }
        }

        if(idx==1){
            for(int i=1;i<=4;++i){
                for(int j=0;j<4;++j){
                    mapN[i][j]=tmpN[i-1][j];
                }
            }
        }

        if(idx==2){
            for(int i=0;i<4;++i){
                for(int j=1;j<=4;++j){
                    mapN[i][j]=tmpN[i][j-1];
                }
            }
        }

        if(idx==3){
            for(int i=1;i<=4;++i){
                for(int j=1;j<=4;++j){
                    mapN[i][j]=tmpN[i-1][j-1];
                }
            }
        }

        return mapN;
    }

    static int[][] sumN(int idx, int [][] mapN, int [][] tmpN){ // map(5), tmp(4)
        if(idx==0){
            for(int i=0;i<4;++i){
                for(int j=0;j<4;++j){
                    mapN[i][j]+=tmpN[i][j];
                }
            }
        }

        if(idx==1){
            for(int i=1;i<=4;++i){
                for(int j=0;j<4;++j){
                    mapN[i][j]+=tmpN[i-1][j];
                }
            }
        }

        if(idx==2){
            for(int i=0;i<4;++i){
                for(int j=1;j<=4;++j){
                    mapN[i][j]+=tmpN[i][j-1];
                }
            }
        }

        if(idx==3){
            for(int i=1;i<=4;++i){
                for(int j=1;j<=4;++j){
                    mapN[i][j]+=tmpN[i-1][j-1];
                }
            }
        }

        return mapN;
    }

    static int [][] copyN(int [][] num){
        int [][] arr=new int [num.length][num.length];

        for(int i=0;i<num.length;++i){
            for(int j=0;j<num.length;++j){
                arr[i][j]=num[i][j];
            }
        }
        return arr;
    }

    static String [][] copyS(String [][] num){
        String [][] arr=new String [num.length][num.length];

        for(int i=0;i<num.length;++i){
            for(int j=0;j<num.length;++j){
                arr[i][j]=num[i][j];
            }
        }
        return arr;
    }

    static String [][] roateS(String [][] arr){
        String [][] tmp=new String [arr.length][arr.length];

        for(int i=0;i<arr.length;++i){
            String [] a=arr[i];
            for(int j=0;j<arr.length;++j){
                tmp[j][arr.length-i-1]=a[j];
            }
        }

        return tmp;
    }

    static int [][] rotate(int [][] arr){
        int [][] tmp=new int [arr.length][arr.length];

            for (int i = 0; i < arr.length; ++i) {
                int[] a = arr[i];
                for (int j = 0; j < arr.length; ++j) {
                    tmp[j][arr.length - i - 1] = a[j];
                }
            }

        return tmp;
    }

    static int calc(int [][] num, String [][] str){
        int R=0,B=0,G=0,Y=0;

        for(int i=0;i<str.length;++i){
            for(int j=0;j<str.length;++j){
                if(str[i][j].equals("R")) R+=num[i][j];
                if(str[i][j].equals("B")) B+=num[i][j];
                if(str[i][j].equals("G")) G+=num[i][j];
                if(str[i][j].equals("Y")) Y+=num[i][j];

            }
        }

        return 7*R+5*B+3*G+2*Y;
    }

    static void perm(int [] arr, int [] output, boolean [] visited,int depth, int n, int r){
        if(depth==r) {
            list.add(output);
            return;
        }

        for(int i=0;i<n;++i){
            if(!visited[i]==true){
                visited[i]=true;
                output[depth]=arr[i];
                perm(arr,output,visited,depth+1,n,r);
                visited[i]=false;
            }
        }
    }

}
