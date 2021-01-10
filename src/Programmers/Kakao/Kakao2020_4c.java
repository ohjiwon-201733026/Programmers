package Programmers.Kakao;

import java.util.Arrays;

public class Kakao2020_4c {
	static class Solution{
	static class Node {
		int count;
		Node[] nodes;

		public void add(String word, int index) {
			++count; // 단어를 add하면서 이노드를 거쳐간다면 ,leaf노드가 하나 추가될 것이다.
			if (index == word.length())
				return; // 인덱스가 범위를 벗어남
			if (nodes == null)
				nodes = new Node[26]; // 알파벳 숫자만큼 자식 노드를 만듬
			int c = word.charAt(index) - 'a'; // word에서 index위치 문자가 'a'이면 0번째,
												// 'b'이면 1 번째, 'c'이면 2번째 자식 노드이어야한다

			if (nodes[c] == null)
				nodes[c] = new Node(); // 그 자식노드가 아직 없다면 만든다.
			nodes[c].add(word, index + 1); // 자식 노드 재귀호출
		}

		public int count(String query, int index) {
			if (nodes == null)
				return count;
			char ch = query.charAt(index);
			if (ch == '?')
				return count;
			Node node = nodes[ch - 'a'];
			if (node == null)
				return 0;
			return node.count(query, index + 1);
		}

//		public void print(String s) {
//			if(nodes!=null) { // 아직 leaf노드가 아니다
//				for(int i=0;i<nodes.length;++i) // 자식 노드 재귀호출 해야한다
//					if(nodes[i]!=null)
//						nodes[i].print(s+(char)('a'+i)); // 현재노드의 문자를 더해서 자식노드 재귀호출
//				System.out.printf("중간: %s %d\n",s,count);  //중간노드의 자식 leaf의 수 출력
//			}
//			else // leaf
//				System.out.println("leaf: "+ s);
//		}
	}

	static Node[] roots1 = new Node[10000], roots2 = new Node[10000]; // 최대 단어길이 10000, 인덱스 범위 0~9999
	// 단어 길이마다 trie 트리를 따로 만든다

	String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	void createTree(String[] words) {
		for (String word : words) {
			int i = word.length() - 1;
			if (roots1[i] == null)
				roots1[i] = new Node();
			if (roots2[i] == null)
				roots2[i] = new Node();
			roots1[i].add(word, 0);
			roots2[i].add(reverse(word), 0);
		}
	}

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		createTree(words);
		for (int i = 0; i < queries.length; ++i) {
			String query = queries[i];
			int j = query.length() - 1;
			if (roots1[j] == null)
				continue;
			if (query.charAt(0) != '?')
				answer[i] = roots1[j].count(query, 0);
			else
				answer[i] = roots2[j].count(reverse(query), 0);
		}
		return answer;
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?", "?????" };
		System.out.println(Arrays.toString(new Solution().solution(words, queries)));
	}

}
