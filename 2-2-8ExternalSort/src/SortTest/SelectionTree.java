package SortTest;

public class SelectionTree {
	int[] a;
	public SelectionTree(int input[]){
		a=input;
	}
	void sort(int[] a){
		for(int i =a.length-1;i>0;i--){
			int m=0;
			for(int j=1; j<=i;j++){
				if(a[j]>a[m])m=j;
			}
			swap(a,i,m);
		}
	}
	public String toString(){
		String b = "";
		for(int i=0; i<a.length;i++)
			b+=a[i]+"\n";
		return b;
	}
	void swap(int a[], int i, int j){
		if(a[i]>a[j]){
			int temp = a[i];
			a[i]= a[j];
			a[j] = temp;
		}
	}
}
