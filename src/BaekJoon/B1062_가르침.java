package BaekJoon;

import java.util.HashSet;
import java.util.Scanner;

public class B1062_가르침 {

    static int n,k;
    static int max=Integer.MIN_VALUE;
    static boolean [] visited;
    static String [] word;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        n=sc.nextInt();
        k=sc.nextInt();

        sc.nextLine();
        word=new String[n];
        for(int i=0;i<n;++i){
            String str=sc.next();
            str=str.replace("anta","");
            str=str.replace("tica","");
            word[i]=str;
        }

        if(k<5){
            System.out.println(0);
            return;
        }
        else if(k==26){
            System.out.println(n);
            return;
        }

        visited=new boolean[26];
        visited['a'-'a']=true;
        visited['c'-'a']=true;
        visited['i'-'a']=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;

        backtracking(0,0);
        System.out.println(max);
    }

    public static void backtracking(int alpha, int len){
        if(len==k-5){
            int count=0;
            for(int i=0;i<n;++i){
                boolean read=true;
                for(int j=0;j< word[i].length();++j){
                    if(!visited[word[i].charAt(j)-'a']){
                        read=false;
                        break;
                    }
                }
                if(read) count++;
            }
            max=Math.max(max,count);
            return;
        }

        for(int i=alpha;i<26;++i){
            if(!visited[i]){
                visited[i]=true;
                backtracking(i,len+1);
                visited[i]=false;
            }
        }
    }
}
