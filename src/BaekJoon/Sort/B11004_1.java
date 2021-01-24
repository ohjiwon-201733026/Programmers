package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B11004_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] tmp=br.readLine().split(" ");
		int n=Integer.parseInt(tmp[0]);
		int k=Integer.parseInt(tmp[1]);

		ArrayList<Integer> num=new ArrayList<>();

		String [] arr=br.readLine().split(" ");


		for(int i=0;i<=arr.length;++i) {
			num.add(Integer.parseInt(arr[i]));
		}

		Collections.sort(num);
		System.out.println(num.get(k-1));

	}

}
