
public class TestAVLtree {

	public static void main(String[] args) {
		System.out.println("삽입 시작");
		AVLTree _avlTree = new AVLTree(3);
		_avlTree.add(5);
		System.out.println(_avlTree);
		_avlTree.add(1);
		System.out.println(_avlTree);
		_avlTree.add(8);
		System.out.println(_avlTree);
		_avlTree.add(6);
		System.out.println(_avlTree);
		_avlTree.add(2);
		System.out.println(_avlTree);
		_avlTree.add(11);
		System.out.println(_avlTree);
		_avlTree.add(4);
		System.out.println(_avlTree);
		_avlTree.add(10);
		System.out.println(_avlTree);
		_avlTree.add(9);
		System.out.println(_avlTree);
		_avlTree.add(7);
		System.out.println(_avlTree);
		System.out.println("삭제 시작");
		
		_avlTree.delete(3);
		System.out.println("3:"+_avlTree);
		_avlTree.delete(5);
		System.out.println("5:"+_avlTree);
		_avlTree.delete(1);
		System.out.println("1:"+_avlTree);
		_avlTree.delete(8);
		System.out.println("8:"+_avlTree);
		_avlTree.delete(6);
		System.out.println("6:"+_avlTree);
		
	
	}
}
