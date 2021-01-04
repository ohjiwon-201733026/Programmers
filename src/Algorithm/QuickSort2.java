package Algorithm;

public class QuickSort2 {
	public static int [] A;

	public static int [] quickSort(int [] A,int p, int r) { //
		if(p<r){
			int q=partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}

		return A;
	}

	public static int partition(int [] A ,int p, int r) {
		int item=A[r];
		int i=p-1;
		int j=p;
		while(j<r) {
			if(item>A[j]) {
				++i;
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
				++j;
			}else {
				++j;
			}
		}
		int tmp=A[i+1];
		A[i+1]=A[r];
		A[r]=tmp;

		return i+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A= new int[]{31,8,48,73,11,3,20,29,65,15};
		int [] answer=quickSort(A,0,A.length-1);

		for(int i=0;i<answer.length;i++) {
			System.out.print(A[i]+" ");
		}
	}

}
