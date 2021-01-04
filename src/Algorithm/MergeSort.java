package Algorithm;

public class MergeSort {
	public static int [] A;

	public static void mergeSort(int p, int r) {
		if(p<r) {
			int q=(p+r)/2;
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);
		}

	}

	public static void merge(int p, int q,int r) {
//		System.out.println(p+" "+q+" "+r);
		int i=p;
		int j=q+1;
		int k=p;
		int [] tmp=new int[A.length];

		while(i<=q&&j<=r) {
			if(A[i]<A[j]) tmp[k++]=A[i++];
			else tmp[k++]=A[j++];
		}

		while(i<=q)
			tmp[k++]=A[i++];
		while(j<=r)
			tmp[k++]=A[j++];
		i=p;k=p;
		while(i<=r) {
			A[i++]=tmp[k++];
		}

		for(int t=p;t<=r;t++) A[t]=tmp[t];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A= new int []{31,3,65,73,8,11,20,29,48,15};
		mergeSort(0,A.length-1);
		for(int  i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
	}

}
