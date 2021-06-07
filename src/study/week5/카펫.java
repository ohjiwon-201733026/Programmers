package study.week5;

public class 카펫 {
    public static void main(String[] args) {
        int brown=14;
        int yellow=4;
        int [] answer=solution(brown,yellow);

        System.out.println(answer[0]+ " "+ answer[1]);
    }

    private static int[] solution(int brown, int yellow) {
        int [] answer=new int [2];
        int r=(int)Math.sqrt(yellow)+1;
        int yM=0,yN=0;

        for(int i=1;i<=r;++i){
            if(yellow%i==0){
                yN=i;
                yM=yellow/i;
                int tmp=yM*2+yN*2+4;
                if(tmp==brown) break;
            }
        }
            answer[0]=yN>=yM?yN+2:yM+2;
            answer[1]=yM<yN?yM+2:yN+2;

        return answer;
    }
}
