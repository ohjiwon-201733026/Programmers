package Algorithm;
/*
조합
: 서로 다른 N개를 순서와 상관없이 R개 뽑는 것, 중복 X-> visit사용
 공동 수상 개념
 경우의 수 : 4*2/2
 (1,2) (1,3) (1,4) (2,3) (2,4) (3,4)
 4명중 공동 수상 2명 뽑기
 */
public class 조합 {
    public static int num;
    public static void main(String[] args) {
        int [] arr={1,2,3,4};
//        int [] output=new int [arr.length];
        boolean [] visited=new boolean[arr.length];
        int n=arr.length;
        num=0;
        comb(arr,visited,0,n,2);
    }

    private static void comb(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r==0){
            for(int i=0;i<visited.length;++i){
                if(visited[i]) System.out.print(arr[i]+" ");
            }
            num++;
            System.out.println("-"+num+"번째 경우");
            return;
        }

        for(int i=start;i<n;++i){
            if(visited[i]!=true){
                visited[i]=true;
                comb(arr,visited,i+1,n,r-1);
                visited[i]=false;
            }
        }
    }

}
