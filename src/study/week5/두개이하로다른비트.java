package study.week5;

public class 두개이하로다른비트 {

    public static void main(String[] args) {
        long [] numbers={3,7,8};
        long [] answer=solutions(numbers);
        for(int i=0;i< answer.length;++i){
            System.out.println(answer[i]);
        }
    }

    private static long[] solutions(long[] numbers) {
        long [] answer=new long [numbers.length];

        for(int i=0;i< numbers.length;++i){
            Long x=numbers[i];

            
            if(x%2==0){ //  짝수인 경우
                answer[i]=x+1;
            }
            else{
                String binary="0"+Long.toBinaryString(numbers[i]);
                int lastIndex=binary.lastIndexOf("0");
                StringBuilder result=new StringBuilder(binary);
                result.setCharAt(lastIndex,'1');
                result.setCharAt(lastIndex+1,'0');
                answer[i]=Long.parseLong(result.toString(),2);
            }

            
        }


        return answer;

    }

}
