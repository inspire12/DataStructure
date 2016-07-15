package SortTest;

public class HeapSort {
	int a[];
	public HeapSort(int input[]){
		a=input;
	}
	public String toString(){
		String b = "";
		for(int i=0; i<a.length;i++)
			b+=a[i]+"\n";
		return b;
	}
	void sort(int[] a){
		for(int i= (a.length-1)/2;i>=0;i--){
			heapify(a, i, a.length);
		}
		for(int j= a.length-1;j>0;j--){//a.length-1은 
			swap(a,0,j);
			heapify(a, 0, j);
		}
	}
	void swap(int a[], int i, int j){
		if(a[i]>a[j]){
			int temp = a[i];
			a[i]= a[j];
			a[j] = temp;
		}
	}
	
	//히프화 메소드, 있는 거 쓹 걸 ㅡㅡ 
	//배열이 힙트리 식으로 정렬되어 있다 가졍
	void heapify(int[] a, int i, int n){
		int ai=a[i];
		while(i<n/2){
			int j=2*i+1; //이부분이 배열 위치를 트리처럼
			if(j+1<n&&a[j+1]>a[j]){
				++j;
			}
			if(a[j]<=ai)break;
			a[i]=a[j];
			i=j;
			
		}
		a[i] = ai;
	}
}
