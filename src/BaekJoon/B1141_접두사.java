package BaekJoon;

import java.util.*;

public class B1141_접두사 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] arr=new String[n];

        for(int i=0;i<n;++i){
            arr[i]=sc.next();
        }

        Set<String> set=new HashSet<>();

        for(int i=0;i<n;++i){
            String origin=arr[i];
            int cnt=0;
            for(int j=0;j<n;++j){
                if(i!=j){
                    String comp=arr[j];

                    if(origin.length()<=comp.length()){
                        for(int k=0;k<origin.length();++k){
                            if(origin.equals(comp)){
                                cnt++;
                                break;
                            }
                            if(origin.charAt(k)!=comp.charAt(k)){
                                cnt++;
                                break;
                            }
                        }
                    }else{
                        cnt++;
                    }
                }
            }

            if(cnt==n-1){
                set.add(origin);
            }
        }
        System.out.println(set.size());

    }
}
