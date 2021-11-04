package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1826_연료채우기 {

    static int N,END, currentFuel;
    static PriorityQueue<Fuel> distQ=new PriorityQueue<>(Comparator.comparingInt(f->f.dist));
    static PriorityQueue<Integer> fuelQ=new PriorityQueue<>(Comparator.comparingInt(o->-o));
    private static class Fuel{
        int dist,quantity;

        public Fuel(int dist, int quantity){
            this.dist=dist;
            this.quantity=quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;++i){
            st=new StringTokenizer(br.readLine());
            int dist=Integer.parseInt(st.nextToken());
            int quan=Integer.parseInt(st.nextToken());
            distQ.add(new Fuel(dist,quan));
        }

        st=new StringTokenizer(br.readLine());
        END=Integer.parseInt(st.nextToken());
        currentFuel=Integer.parseInt(st.nextToken());

        solve();


    }

    private static void solve(){
        int answer=0;

        while(END>currentFuel){
            // 연료도 없고, 주유소도 없음
            if(fuelQ.isEmpty() && distQ.isEmpty()){
                answer=-1;
                break;
            }

            // 연료 없고, 주유소 못감
            if(fuelQ.isEmpty() && distQ.peek().dist > currentFuel){
                answer=-1;
                break;
            }

            // 갈 수 있는 주유소 담기
            while(!distQ.isEmpty()&& distQ.peek().dist<=currentFuel){
                fuelQ.add(distQ.poll().quantity);
            }

            // 연료 충전
            if(!fuelQ.isEmpty()){
                currentFuel+=fuelQ.poll();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
