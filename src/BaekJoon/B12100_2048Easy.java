package BaekJoon;

import java.util.Scanner;

public class B12100_2048Easy {

    static int n;
    static int max;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        max=0;
        int [][] map=new int [n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                map[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<4;++i){ // dir 0:위, 1: 아래, 2: 오른쪽, 3: 왼쪽
            dfs(i,map,0);
        }

        System.out.println(max);
    }

    public static void dfs(int dir,int [][] arr,int depth){
        if(depth==5){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(max<arr[i][j]) max=arr[i][j];
                }
            }

            return;
        }

        for(int i=0;i<4;++i){
            dfs(i,move(dir,arr),depth+1);
        }
    }

    public static int [][] move(int dir, int [][] arr){
        int [][] tmp=new int [n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                tmp[i][j]=arr[i][j];
            }
        }

        if(dir==0){ // 위
            for(int k=0;k<n;++k){
                for(int i=n-1;i>=0;--i){
                    if(arr[i][k]==0){
                        for(int j=i+1;j<n;++j){
                            tmp[j-1][k]=tmp[j][k];
                            tmp[j][k]=0;
                        }
                    }
                }
            }

            for(int i=0;i<n;++i){
                for(int j=0;j<n-1;++j){
                    if(tmp[j][i]==tmp[j+1][i]){
                        tmp[j][i]+=tmp[j+1][i];
                        tmp[j+1][i]=0;
                    }
                }
            }

            for(int k=0;k<n;++k){
                for(int i=n-1;i>=0;--i){
                    if(tmp[i][k]==0){
                        for(int j=i+1;j<n;++j){
                            tmp[j-1][k]=tmp[j][k];
                            tmp[j][k]=0;
                        }
                    }
                }
            }

        }

        if(dir==1){ // 아래
            for(int k=0;k<n;++k){
                for(int i=0;i<n;++i){
                    if(arr[i][k]==0){
                        for(int j=i-1;j>=0;--j){
                            tmp[j+1][k]=tmp[j][k];
                            tmp[j][k]=0;
                        }
                    }
                }
            }

            for(int i=0;i<n;++i){
                for(int j=n-1;j>=1;--j){
                    if(tmp[j][i]==tmp[j-1][i]){
                        tmp[j][i]+=tmp[j-1][i];
                        tmp[j-1][i]=0;
                    }
                }
            }

            for(int k=0;k<n;++k){
                for(int i=0;i<n;++i){
                    if(tmp[i][k]==0){
                        for(int j=i-1;j>=0;--j){
                            tmp[j+1][k]=tmp[j][k];
                            tmp[j][k]=0;
                        }
                    }
                }
            }
        }

        if(dir==2){ // 오른쪽
            for(int k=0;k<n;++k){
                for(int i=0;i<n;++i){
                    if(arr[k][i]==0){
                        for(int j=i-1;j>=0;--j){
                            tmp[k][j+1]=tmp[k][j];
                            tmp[k][j]=0;
                        }
                    }
                }
            }

            for(int i=0;i<n;++i){
                for(int j=n-1;j>0;--j){
                    if(tmp[i][j]==tmp[i][j-1]){
                        tmp[i][j]+=tmp[i][j-1];
                        tmp[i][j-1]=0;
                    }
                }
            }

            for(int k=0;k<n;++k){
                for(int i=0;i<n;++i){
                    if(tmp[k][i]==0){
                        for(int j=i-1;j>=0;--j){
                            tmp[k][j+1]=tmp[k][j];
                            tmp[k][j]=0;
                        }
                    }
                }
            }

        }

        if(dir ==3){ // 왼쪽
            for(int k=0;k<n;++k){
                for(int i=n-1;i>=0;--i){
                    if(arr[k][i]==0){
                        for(int j=i+1;j<n;++j){
                            tmp[k][j-1]=tmp[k][j];
                            tmp[k][j]=0;
                        }
                    }
                }
            }

            for(int i=0;i<n;++i){
                for(int j=0;j<n-1;++j){
                    if(tmp[i][j]==tmp[i][j+1]){
                        tmp[i][j]+=tmp[i][j+1];
                        tmp[i][j+1]=0;
                    }
                }
            }

            for(int k=0;k<n;++k){
                for(int i=n-1;i>=0;--i){
                    if(tmp[k][i]==0){
                        for(int j=i+1;j<n;++j){
                            tmp[k][j-1]=tmp[k][j];
                            tmp[k][j]=0;
                        }
                    }
                }
            }
        }


        return tmp;
    }
}
