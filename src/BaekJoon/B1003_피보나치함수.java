package BaekJoon;

import java.util.Scanner;

public class B1003_피보나치함수 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        int [] zero=new int [41];
        int [] one=new int [41];

        zero[0]=1;
        one[1]=1;

        for(int i=2;i<=40;++i){
            zero[i]=zero[i-1]+zero[i-2];
            one[i]=one[i-1]+one[i-2];
        }

        StringBuilder sb=new StringBuilder();
        while (t-->0){
            int n=sc.nextInt();
            sb.append(zero[n]+" "+one[n]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
