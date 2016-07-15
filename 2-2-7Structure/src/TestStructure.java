import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class TestStructure {
	public static void main(String[] args) {
		new TestStructure("file");
	}

	public TestStructure(String file){
		int lineNumber =0;
//		int countAccess=0;

		try {

			BufferedReader in = new BufferedReader(new FileReader(file));

			String line = in.readLine();


			singlyLinkedList TestSinglyLinkedList = new singlyLinkedList();
			binarySearchTree TestBinarySearchtree = new binarySearchTree();
			AVLTree TestAVLTree = new AVLTree();
			final AVLTree NIL = TestAVLTree;

			hashing TestHashing = new hashing();
			
			int numberofword=0;
			while(line!=null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line," ,:;-.?!--");

				while(parser.hasMoreTokens()){
					String word = parser.nextToken().toUpperCase();
					numberofword++;
					//노드에 넣는 부분
					TestSinglyLinkedList.add(word);	
					/*if(word.charAt(0)=='D'){
						System.out.println("?");
					}*/
					TestHashing.put(word);
					
					if(TestAVLTree==NIL){	
						TestAVLTree = new AVLTree(word);
						TestBinarySearchtree = new binarySearchTree(word);
						
						continue;
					}
							
					if(TestAVLTree!=NIL){
					
						TestAVLTree.add(word);
						TestBinarySearchtree.add(word);
						
					}
					
					
					//혹시 기존에 있으면 저장된 노드로 가서 +1한다.
				}
				System.out.println(lineNumber+":\t"+line);
				line=in.readLine();
			}
			//search 부분
			System.out.println("단어의(n)의 수 "+numberofword);
		/*	System.out.println("LinkedList의 총 접근 횟수는 "+TestSinglyLinkedList.getCountAccess());
			System.out.println(TestSinglyLinkedList);
*/			line();
			System.out.println("AVLTree의 총 접근 횟수는 "+AVLTree.countAccess);
			System.out.println(TestAVLTree);
			line();
			System.out.println("binarySearchTree의 총 접근 횟수는 "+binarySearchTree.countAccess);
			System.out.println(TestAVLTree);
		
/*			System.out.println("Hashing의 총 접근 횟수는 "+hashing.countAccess);
			System.out.println("충돌 횟수 : "+TestHashing.howManyCollins());
			System.out.println(TestHashing);
*/			
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lines:"+lineNumber);
		}

	}
	public void line(){
		System.out.println("=================================");
	}
	

}
