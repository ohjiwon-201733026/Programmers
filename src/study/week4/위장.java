package study.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 위장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] clothes= {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
		int result=solution(clothes);
		System.out.println(result);
	}

	private static int solution(String[][] clothes) {
		// TODO Auto-generated method stub
		Map<String,ArrayList<String>> map=new HashMap<>();

		for(int i=0;i<clothes.length;++i) {
			String [] a=clothes[i];
			if(map.containsKey(a[1])) {
				ArrayList<String> arr=map.get(a[1]);
				arr.add(a[0]);
			}
			else {
				ArrayList<String> arr=new ArrayList<>();
				arr.add(a[0]);
				map.put(a[1], arr);
			}
		}

		int m=map.size();
		int answer=0;
		int tmp=1;
		for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
			if(m==1) {
				answer=entry.getValue().size();
				return answer;
			}
			else {
				tmp*=(entry.getValue().size()+1);
			}

		}
		answer=tmp-1;
		return answer;
	}

}
