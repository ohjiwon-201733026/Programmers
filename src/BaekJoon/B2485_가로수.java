package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2485_가로수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        ArrayList<Integer> tree=new ArrayList<>();
        ArrayList<Integer> term=new ArrayList<>();

        while(N-->0){
            tree.add(sc.nextInt());
        }

        Collections.sort(tree);

        for(int i=0;i<tree.size()-1;++i){
            term.add(tree.get(i+1)-tree.get(i));
        }

        int max=term.get(0);
        for(int i=1;i<term.size();++i){
            max=gcd(max,term.get(i));
        }
        int answer=0;
        for(int i=0;i<term.size();++i){
            answer+=(term.get(i)/max)-1;
        }

        System.out.println(answer);

    }

    public static int gcd(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
