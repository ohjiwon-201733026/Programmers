package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15686_치킨배달 {
    static int N,M;
    static int [][] map;
    static ArrayList<House> chickens;
    static ArrayList<House> houses;
    static Stack<House> selectChicken;
    static int minDist=Integer.MAX_VALUE;


    static class House{
        int x, y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selectChicken = new Stack<>();

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) houses.add(new House(i, j));
                else if (map[i][j] == 2) chickens.add(new House(i, j));
            }
        }

        select(0, 0);

        System.out.println(minDist);

    }

    static void select(int start, int count){
        if(count==M){
            calcDist();
            return ;
        }

        for(int i=start;i<chickens.size();++i){
            selectChicken.push(chickens.get(i));
            select(i+1,count+1);
            selectChicken.pop();
        }
    }

    static void calcDist(){
        int sum=0;

        for(House house:houses){
            int min=Integer.MAX_VALUE;
            for(House chicken : selectChicken){
                int dist=Math.abs(house.x- chicken.x)+Math.abs(house.y-chicken.y);
                min=Math.min(min,dist);
            }
            sum+=min;

            if(sum>minDist) return;
        }
        minDist=Math.min(sum,minDist);
    }
}
