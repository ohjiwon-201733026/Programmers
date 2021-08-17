package Programmers.Lv2;

public class 프렌즈4블록 {
    public static void main(String [] args){
        int m=4;
        int n=5;
        String [] board={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));

    }
    public static int answer=0;
    public static boolean [][] visit;
    public static int solution(int m, int n, String [] board){
        char [][] map=new char [m][n];

        for(int i=0;i< board.length;++i){
            map[i]=board[i].toCharArray();
        }
        while(true) {
            visit=new boolean[m][n];
            for (int i = 0; i <= m - 2; ++i) {
                for (int j = 0; j <= n - 2; ++j) {
                    char c = map[i][j];
                    if (c != 'x' && map[i + 1][j] == c && map[i + 1][j + 1] == c && map[i][j + 1] == c) {
                        visit[i][j] = visit[i + 1][j] = visit[i][j + 1] = visit[i + 1][j + 1] = true;
                    }
                }
            }
            int cnt = check(m, n);
            if (cnt == 0) break;
            answer+=cnt;

            for(int i=0;i<n;++i){
                if(visit[0][i]) map[0][i]='x';
            }

            for(int i=1;i<m;++i){
                for(int j=0;j<n;++j){
                    if(visit[i][j]){
                        for(int k=i-1;k>=0;--k){
                            map[k+1][j]=map[k][j];
                            map[k][j]='x';
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static int check(int m,int n){
        int cnt=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(visit[i][j]) { cnt++; }
            }
        }

        return cnt;
    }


}
