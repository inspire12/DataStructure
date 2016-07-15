package hashing;

public class TestHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashTable_linear hashTable_linear = new hashTable_linear(17,9);
		hashTable_linear.print();
		
		hashTable_square hashTable_square = new hashTable_square(17,9);
		hashTable_square.print();
		
		hashTable_double hashTable_double = new hashTable_double(17,9);
		hashTable_double.print();
		
	}
	
	
}
