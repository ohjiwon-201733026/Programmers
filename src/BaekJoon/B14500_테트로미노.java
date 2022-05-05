package BaekJoon;

import java.util.Scanner;

public class B14500_테트로미노 {
    static int n,m;
    static int [][] map;
    static int [][][] tetro= {
            {
                {1, 1, 1, 1}, {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,1,0},
                    {0,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 6][m + 6];

        for (int i = 3; i < 3 + n; ++i) {
            for (int j = 3; j < 3 + m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;


        for (int i = 0; i < 5; ++i) {
            int[][] tet = tetro[i];
            // 회전
            for (int k = 0; k < 4; ++k) {
                tet = rotate(tet);

                for (int j = 0; j <= n + 2; ++j) {
                    for (int l = 0; l <= m + 2; ++l) {
                        int sum = 0;
                        for (int x = j; x < j + 4; ++x) {
                            for (int y = l; y < l + 4; ++y) {
                                if (tet[x - j][y - l] == 1) sum += map[x][y];
                            }
                        }
                        answer = Math.max(answer, sum);
                    }
                }

                // 좌우 대칭
                tet = symLR(tet);
                for (int j = 0; j <= n + 2; ++j) {
                    for (int l = 0; l <= m + 2; ++l) {
                        int sum = 0;
                        for (int x = j; x < j + 4; ++x) {
                            for (int y = l; y < l + 4; ++y) {
                                if (tet[x - j][y - l] == 1) sum += map[x][y];
                            }
                        }
                        answer = Math.max(answer, sum);
                    }

                }
                tet = symLR(tet);
                for (int j = 0; j <= n + 2; ++j) {
                    for (int l = 0; l <= m + 2; ++l) {
                        int sum = 0;
                        for (int x = j; x < j + 4; ++x) {
                            for (int y = l; y < l + 4; ++y) {
                                if (tet[x - j][y - l] == 1) sum += map[x][y];
                            }
                        }
                        answer = Math.max(answer, sum);
                    }

                }

                tet=symUD(tet);
                for (int j = 0; j <= n + 2; ++j) {
                    for (int l = 0; l <= m + 2; ++l) {
                        int sum = 0;
                        for (int x = j; x < j + 4; ++x) {
                            for (int y = l; y < l + 4; ++y) {
                                if (tet[x - j][y - l] == 1) sum += map[x][y];
                            }
                        }
                        answer = Math.max(answer, sum);
                    }

                }

                tet=symUD(tet);
                for (int j = 0; j <= n + 2; ++j) {
                    for (int l = 0; l <= m + 2; ++l) {
                        int sum = 0;
                        for (int x = j; x < j + 4; ++x) {
                            for (int y = l; y < l + 4; ++y) {
                                if (tet[x - j][y - l] == 1) sum += map[x][y];
                            }
                        }
                        answer = Math.max(answer, sum);
                    }

                }
            }
        }
        System.out.println(answer);

    }

    public static int [][] rotate(int [][] pattern){
        int [][] tmp=new int [4][4];

        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                tmp[j][3-i]=pattern[i][j];
            }
        }


        return tmp;
    }

    public static int [][] symLR(int [][] pattern){
        int [][] tmp=new int [4][4];

        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                tmp[i][j]=pattern[i][3-j];
            }
        }

        return tmp;
    }

    public static int [][] symUD(int [][] pattern){
        int [][] tmp=new int [4][4];

        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                tmp[j][i]=pattern[3-j][i];
            }
        }

        return tmp;
    }
}
