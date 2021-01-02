package Programmers.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort1 {
	public static int [] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];

        for(int i=0;i<commands.length;i++) {
        		int [] temp=new int[commands[i][1]-commands[i][0]+1];
        		for(int j=0;j<temp.length;j++) {
        			temp[j]=array[commands[i][0]-1+j];
        	}
        		Arrays.sort(temp);
        		answer[i]=temp[commands[i][2]-1];
        }

        return answer;


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int[] array= new int[a];
		for(int i=0;i<a;i++) {
			array[i]=sc.nextInt();
		}
		int n=sc.nextInt();
		int [][] commands=new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
			commands[i][j]=sc.nextInt();
			}
		}

		int [] answer=solution(array,commands);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}

}
