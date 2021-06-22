package study.week7;

public class 가장큰정사각형 {

    public static void main(String[] args) {
        int [][] board={{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int ans=solution(board);
        System.out.println(ans);
    }

    private static int solution(int[][] board) {
        int max=0;
        if(board.length==1 || board[0].length==1) return 1;
        for(int i=1;i< board.length;++i){
            for(int j=1;j<board[i].length;++j){
                if(board[i][j]!=0){
                    int left=board[i][j-1]; // 왼
                    int up=board[i-1][j]; // 위
                    int leftUp=board[i-1][j-1]; // 대각선
                    board[i][j]=Math.min(left,Math.min(leftUp,up))+1;
                    if(max<board[i][j]) max=board[i][j];
                }

            }
        }

        return max*max;
    }
}
