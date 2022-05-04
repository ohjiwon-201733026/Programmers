package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class B2671_잠수함식별 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        // +는 앞의 문자가 1개 이상 있다는 것
        // 문제에서 특정한 소리의 반복은 ~로 표시하는데 이것이 한번 이상 반복되는 것이므로 + tkdyd
        String pattern="(100+1+|01)+";

        System.out.println(s.matches(pattern) ? "SUBMARINE" : "NOISE");


    }
}
