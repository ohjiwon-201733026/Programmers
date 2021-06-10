package study.week5;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        int m=6;
        int n=6;
        String [] board={"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int answer =solution(m,n,board);
        System.out.println(answer);
    }
    public static boolean [][] visit;
    public static char [][] map;
    private static int solution(int m, int n, String[] board) {
        map=new char[m][n];
        int answer=0;
        // 입력
        for(int i=0;i<m;++i){
            String s=board[i];
            for(int j=0;j<n;++j){
                map[i][j]=s.charAt(j);
            }
        }
        while(true) {
            visit=new boolean[m][n];
            // 4블록 찾기
            for (int i = 0; i <= m - 2; ++i) {
                for (int j = 0; j <= n - 2; ++j) {
                    char c = map[i][j];
                    if (c != '-' && map[i + 1][j] == c && map[i][j + 1] == c && map[i + 1][j + 1] == c) {
                        visit[i][j] = visit[i + 1][j] = visit[i][j + 1] = visit[i + 1][j + 1] = true;

                    }
                }
            }
            int score = check(m, n); // 지울 블럭 개수
            if (score == 0) break; // 더 블록 없으면 끝
            answer += score;


            for(int j=0;j<n;++j){
                if(visit[0][j]) map[0][j]='-';
            }

            for(int i=1;i<m;++i){
                for(int j=0;j<n;++j){
                    if(visit[i][j]){
                        for(int k=i-1;k>=0;--k){
                            map[k+1][j]=map[k][j];
                            map[k][j]='-';
                        }
                    }
                }
            }


        }


        return answer;

    }

    private static int check(int m, int n) {
        int num=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(visit[i][j]) {
                    num++;
                    map[i][j]='-';
                }

            }
        }
        return num;
    }
}
