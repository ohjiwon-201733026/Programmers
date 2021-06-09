package study.week5;

public class 두개이하로다른비트 {

    public static void main(String[] args) {
        long [] numbers={4};
        long [] answer=solutions(numbers);
        for(int i=0;i< answer.length;++i){
            System.out.println(answer[i]);
        }
    }

    private static long[] solutions(long[] numbers) {
        long [] answer=new long [numbers.length];
        for(int i=0;i<numbers.length;++i){
            String s=String.format("%050d",Integer.parseInt(Long.toBinaryString(numbers[i]).toString()));
            long diff=0;
            long n=numbers[i];
            while(true){
                n++;
                String next=String.format("%050d",Integer.parseInt(Long.toBinaryString(n).toString()));
                diff=bitDiff(s,next);
                if(diff==2||diff==1) break;
            }
            answer[i]=n;

        }

        return answer;

    }

    private static long bitDiff(String s, String next) {
        long diff=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)!=next.charAt(i)) diff++;
        }
        return diff;
    }
}
