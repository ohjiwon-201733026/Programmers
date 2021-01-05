package Algorithm;

public class HeapSort {
	public static int [] A;

	public static void buildHeap(int [] A, int n) {
		int start=n/2;
		for(int i=start;i>=1;--i) {
			heapify(A,i,n);
		}
	}

	public static void heapify(int [] A,int k, int n) {
		int left=2*k;
		int right=2*k+1;
		int smaller;
		if(right<=n) { // 자식 2개인 경우

			if(A[left]<A[right]) smaller=left;
			else smaller=right;
		}
		else if(left<=n) smaller=left; // 자식 1개인경우
		else return; // 리프노드인 경우

		if(A[smaller]<A[k]) {
			int temp=A[k];
			A[k]=A[smaller];
			A[smaller]=temp;
			heapify(A,smaller,n);
		}
	}
	public static void heapSort(int [] A, int n) {
		buildHeap(A,n);

		for(int i=n-1;i>=1;i--) {
			int temp=A[0];
			A[0]=A[i];
			A[i]=temp;
			heapify(A,0,i-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A= new int []{3,6,4,8,9,7};
		heapSort(A,A.length-1);

		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}

	}

}
