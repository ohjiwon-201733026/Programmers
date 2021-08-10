package Programmers.Lv2;

public class 두개이하로다른비트 {
    public static void main(String[] args) {
        long [] numbers={2,7};
        long [] result=solution(numbers);

        for(long r: result) System.out.println(r);
    }

    public static long [] solution(long [] numbers){
        long [] answer=new long [numbers.length];
        for(int i=0;i< numbers.length;++i){
            if(numbers[i]%2==0) answer[i]=numbers[i]+1;
            else{
                String binary="0"+Long.toBinaryString(numbers[i]);
                int lastIdx=binary.lastIndexOf('0');
                StringBuilder result=new StringBuilder(binary);
                result.setCharAt(lastIdx,'1');
                result.setCharAt(lastIdx+1,'0');
                answer[i]=Long.parseLong(result.toString(),2);

            }
        }

        return answer;
    }
}
