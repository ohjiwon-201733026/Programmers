// 행렬 경로 문제
package Algorithm.DynamicProgramming;

public class MatrixPathProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr= {{6,7,12,5},
				     	  {5,3,11,18},
				     	  {7,17,3,3},
				     	  {8,10,14,9}};
		int [][] mat=new int [4][4];
		int n=arr.length;

//

		for(int i=0;i<n;i++) mat[i][0]=0;
		for(int i=0;i<n;i++) mat[0][i]=0;

		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				mat[i][j]=arr[i][j]+Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}

		System.out.println(mat[n-1][n-1]);



//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr.length;j++) {
//				System.out.print(mat[i][j]+" ");
//			}
//			System.out.println();
//		}



	}

}
