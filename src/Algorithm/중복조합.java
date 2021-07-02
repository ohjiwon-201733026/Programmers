package Algorithm;
/*
중복조합
: N개를 R개만큼 뽑는데 순서와 상관없이 중복해서 뽑아도 된다.
공동수상 2명인데 2개다 1명이 받기 가능
(1,1)
(2,2)
(1,2) O
(2,1) X
 */
public class 중복조합 {
    public static int num;
    public static void main(String[] args) {
        int [] arr={1,2,3,4};
        int [] output=new int [arr.length];
        boolean [] visited=new boolean [arr.length];
        int n=4;
        num=0;
        perm(arr,output,visited,1,n,2,0);
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int start, int n, int r, int cnt) {
        if(cnt==r){
            for(int i=0;i<cnt;++i) System.out.println(output[i]+" ");
            num++;
            System.out.println("-"+num+"번째경우");
            return;
        }

        for(int i=start-1;i<n;++i){
            visited[i]=true;
            output[cnt]=arr[i];
            perm(arr,output,visited,i+1,n,r,cnt+1);
            visited[i]=false;
        }
    }
}
