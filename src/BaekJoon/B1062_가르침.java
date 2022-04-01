package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1062_가르침 {
    static int n,k;
    static boolean [] visited;
    static ArrayList<String> arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        visited=new boolean[26];
        arr=new ArrayList<>();

        for(int i=0;i<n;++i){
            String str=sc.next();
            str=str.replace("anta","");
            str=str.replace("tica","");
            arr.add(str);
        }

        if(k<5){
            System.out.println("0");
            return;
        }
        else if(k>=26){
            System.out.println(n);
            return;
        }

        visited['a'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;

        backtracking(0,0);
        System.out.println(answer);
    }
    static int answer=0;
    public static void backtracking(int alpha,int depth){
        if(depth==k-5){
            int count=0;
            for (String s : arr) {
                boolean flag=true;
                for(int i=0;i<s.length();++i){
                    if(!visited[s.charAt(i)-'a']){
                        flag=false;
                        break;
                    }
                }

                if(flag) count++;
            }

            answer=Math.max(count,answer);
            return;
        }

        for(int i=alpha;i<26;++i){
            if(!visited[i]){
                visited[i]=true;
                backtracking(i,depth+1);
                visited[i]=false;
            }
        }
    }
}
