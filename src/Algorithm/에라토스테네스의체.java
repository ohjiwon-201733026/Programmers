package Algorithm;

import org.junit.platform.commons.util.StringUtils;

public class 에라토스테네스의체 {

    static boolean [] prime=new boolean[121];
    public static void main(String[] args) {
        int n=120;

        prime[0]=prime[1]=true;

        for(int i=2;i*i<=n;++i){
            if(!prime[i]){
                for(int j=i*i;j<=n;j+=i) prime[j]=true;
            }
        }

        for(int i=1;i<=n;++i){
            if(!prime[i]) System.out.println(i+" ");
        }

    }

}
