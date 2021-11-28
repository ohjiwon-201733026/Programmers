package BaekJoon;

import java.util.Scanner;

public class B2661_좋은수열 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        backtracking("",N);
    }

    public static void backtracking(String result,int N){
        if(result.length()==N){
            System.out.println(result);
            System.exit(0);
        }
        else{
            for(int i=1;i<=3;++i){
                if(isGoodSequence(result+i)){
                    backtracking(result+i,N);
                }
            }
        }
    }

    public static boolean isGoodSequence(String result){
        int length=result.length()/2;

        for(int i=1;i<=length;++i){
            if(result.substring(result.length()-i).equals(result.substring(result.length()-2*i,result.length()-i))){
                return false;
            }
        }
        return true;
    }
}
