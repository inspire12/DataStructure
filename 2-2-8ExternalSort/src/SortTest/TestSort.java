package SortTest;


public class TestSort {
	public static void main(String[] args) {
		int input[] = {1,9,11,19,21,31,41,51,61,71};
		//HeapSort test = new HeapSort(input);
		SelectionTree test = new SelectionTree(input);
		test.sort(input);
		System.out.println(test.toString());
	}
			
			

}
