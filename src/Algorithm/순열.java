package Algorithm;
// 순열
// 서로 다른 N개를 중복 허락하지 않고 R개를 일렬로 나열
//(1,2,3,4) 중 1등 2등 뽑기
// 경우의 수 : 4*3
// 1,2/ 1,3/ 1,4/ 2,1/ 2,3/ 2,4/ 3,1/ 3,2/ 3,4/ 4,1/ 4,2/ 4,3
// 나 자신을 포함하지 않음 -> 중복 허락 X ( 포함하면 1,1 2,2 이런거 포함 )
// 중복 허락 안하니까 visit 배열로 중복 체크
// 1등으로 뽑히면 더 뽑히면 안되므로 visit 배열 true
// output에 순서대로 저장한다 (depth로 순서 알 수 있다)
public class 순열 {
    //4개중 3개 뽑음
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8};
        int [] output=new int [arr.length];
        boolean [] visited=new boolean [arr.length];
        int n=8;
        perm(arr,output,visited,0,n,8);
    }

    private static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth==r) {
            for (int i = 0; i < r; ++i) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
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
