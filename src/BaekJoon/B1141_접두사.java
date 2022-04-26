package BaekJoon;

import java.util.*;

public class B1141_접두사 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] arr=new String[n];
        for(int i=0;i<n;++i) arr[i]=sc.next();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        HashSet<String> set=new HashSet<>();
        set.add(arr[0]);

        for (String prefix : arr) {

            boolean flag=true;
            for (String s : set) {
                if(s.startsWith(prefix)) {
                    flag=false;
                    break;
                }
            }

            if(flag) set.add(prefix);
        }

        System.out.println(set.size());

    }
}
