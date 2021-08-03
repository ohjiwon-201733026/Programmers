public class Yogiyo3 {

    public static void main(String[] args) {
        int N=44432;
        int answer= solution(N);
        System.out.println(answer);
    }

    public static int check(int n){
        String s=Integer.toString(n);
        char pre=s.charAt(s.length()-1);
        for(int i=s.length()-2;i>=0;--i){
            if(pre==s.charAt(i)) return i;
            else pre=s.charAt(i);
        }

        return -1;
    }

    private static int solution(int N) {
        N+=1;

        while(true){
            if(check(N)==-1) break;
            int idx=check(N)+1;
            String s=Integer.toString(N);
            if(idx==s.length()-1) N++;
            else {
                int change = s.charAt(idx) - '0';
                change++;
                if (change == 10) idx--;
                StringBuilder sb = new StringBuilder(s.substring(0, idx) + change);

                for (int i = idx; i < s.length(); ++i) sb.append("0");
                N = Integer.parseInt(sb.toString());
            }

        }

        return N;
    }
}
