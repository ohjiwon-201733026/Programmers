package Algorithm;
/*
중복 순열
: 서로 다른 N개를 "중복을 허락"하고 R개를 뽑는다.
1등했던 애가 2등 3등 가능 , 중복 수상 가능
경우의 수: 4*4*4
1 1 1
1 1 2
1 1 3
...
4 4 4
 */
public class 중복순열 {
    public static int num;
    public static void main(String[] args) {
        int [] arr={1,2,3,4};
        int [] output=new int [arr.length];
        boolean [] visited=new boolean[arr.length];
        int n=4;
        num=0;
        perm(arr,output,visited,0,n,3);
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r){
            for(int i=0;i<r;++i){
                System.out.print(output[i]+" ");
            }
            num++;
            System.out.println(num);
            return;
        }

        for(int i=0;i<n;++i){
//            visited[i]=true;
            output[depth]=arr[i];
            perm(arr,output,visited,depth+1,n,r);
//            visited[i]=false;
        }
    }
}
