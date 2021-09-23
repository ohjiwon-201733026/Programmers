package Programmers.Lv3;

public class 징검다리건너기 {
    public static void main(String[] args) {
        int [] stones={2,4,5,3,2,1,4,2,5,1};
        int k=3;
        System.out.println(solution(stones,k));
    }

    private static int solution(int[] stones, int k) {

        int max=0;
        for(int n:stones){
            if(max<n) max=n;
        }

        int answer=binarySearch(max,stones,k);
        return answer;
    }

    public static int binarySearch(int max, int [] stones, int k){
        int start=0;
        int end=max;
        int mid=0;
        int answer=0;
        while(start<=end){
            mid=(start+end)/2;
            if(!cross(mid,stones,k)) end=mid-1;
            else {
                start=mid+1;
                answer=Math.max(answer,mid);
            }
        }

        return mid;
    }

    private static boolean cross(int mid, int[] stones, int k) {
        int cnt=0;
        for(int stone:stones){
            if(stone-mid<0) cnt++;
            else cnt=0;

            if(cnt==k) return false;
        }
        return true;
    }
}
