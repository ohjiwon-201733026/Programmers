// 외벽 점검
package Programmers.Kakao;

import java.util.Arrays;

public class Kakao2020_6 {

	public static void main(String[] args) {
		int[] weak1 = { 1, 5, 6, 10 };
		int[] dist1 = { 1, 2, 3, 4 };
		System.out.println(new Solution().solution(12, weak1, dist1));
		int[] weak2 = {1, 3, 4, 9, 10};
		int[] dist2 = {3, 5, 7};
		System.out.println(new Solution().solution(12, weak2, dist2));
	}

	static class Solution{
		int 외벽길이;
		int [] 친구목록, 취약점목록;

		void cover(int 출발index, int 친구거리, boolean [] covered2) { // 친구가 수리한 취약점을 체크하는 함수
			for(int j=출발index; j<취약점목록.length; ++j) {
				int 거리=취약점목록[j]-취약점목록[출발index];
				if(거리<=친구거리) covered2[j]=true;
				else break;
			}
			if(취약점목록[출발index]+친구거리>=외벽길이) { // 넘어가는 경우
				int 남은거리=(취약점목록[출발index]+친구거리)-외벽길이;
				for(int j=0;j<취약점목록.length;++j) {
					int 거리=취약점목록[j];
					if(거리<=남은거리) covered2[j]=true;
					else break;
				}
			}
		}

		int 남은취약점수(boolean [] covered2) { // covered2 배열을 확인해 남은 취약점 개수를 리턴!
			int count=0;
			for(boolean f: covered2)
				if(!f) ++count;
			return count;

		}

		int solution(int 친구index, boolean[] covered) {
			if(친구index<0) return Integer.MAX_VALUE;
			int 최소값=Integer.MAX_VALUE;
			int 친구거리=친구목록[친구index]; // 친구목록에서 이동거리가 제일 긴 친구부터
			for(int i=0;i<covered.length;++i) { // 취약점 하나하나씩 모든 경우의수 확인
				if(covered[i]) continue;
				boolean [] covered2=Arrays.copyOf(covered,covered.length);
				cover(i,친구거리,covered2);
				if(남은취약점수(covered2)==0) // 취약점 모두 고침
					return 친구목록.length-친구index; // 전체 명수 - 친구index
				else {
					int r=solution(친구index-1,covered2); // 다음으로 이동거리가 작은 친구index로
					if(r<최소값) 최소값=r;
				}
			}
			return 최소값;
		}

		public int solution(int n, int [] weak, int [] dist) {
			외벽길이=n; 취약점목록=weak; 친구목록=dist;
			Arrays.sort(친구목록);
			int r =solution(친구목록.length-1, new boolean[취약점목록.length]);
			return r==Integer.MAX_VALUE?-1:r;
		}
	}

}
