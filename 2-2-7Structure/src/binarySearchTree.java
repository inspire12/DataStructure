
public class binarySearchTree {
	private Key key;
	private int height;
	private binarySearchTree left, right;

	public static int countAccess=0;
	public static final binarySearchTree NIL = new binarySearchTree();


	public binarySearchTree(String key){

		this.key = new Key(key,1);
		left = right = NIL;

	}

	public binarySearchTree(String key,int count){

		this.key = new Key(key,count);
		left = right = NIL;

	}
	//생성자 하나만 사용자가 쓸수 있게 통제 임의로 만들수 없게
	public binarySearchTree(){

		left = right =this;
		height=-1;

	}
	private void setLeft(binarySearchTree a){
		this.left = a;

	}
	private void setRight(binarySearchTree a){
		this.right=a;

	}
	private binarySearchTree(String key,binarySearchTree left, binarySearchTree right){

		this.key=new Key(key,1);
		this.left=left;
		this.right=right;
		height = 1+Math.max(left.height, right.height);


	}
	private binarySearchTree(String key,binarySearchTree left, binarySearchTree right,int count){

		this.key=new Key(key,count);
		this.left=left;
		this.right=right;
		height = 1+Math.max(left.height, right.height);


	}
	public binarySearchTree(Key key, binarySearchTree left, binarySearchTree right) {
		// TODO Auto-generated constructor stub
		this.key=key;
		this.left=left;
		this.right=right;
		height = 1+Math.max(left.height, right.height);

	}

	public boolean add(String key){
		int oldSize=size();
		grow(key);
		return size()>oldSize;
	}
	private static void incAccess(){
		binarySearchTree.countAccess++;
	}
	private void incCount(){
		this.key._count++;
	}
	private binarySearchTree grow(String key){
		incAccess();

		if(this==NIL){ 
			return new binarySearchTree(key);}
		if(key.equals(this.key.get_element())) {
			incCount();
			return this;
		}
		if(key.compareTo(this.key.get_element())<0){
			left = left.grow(key);
		}else {
			right = right.grow(key);
		}
		
		height = 1+Math.max(left.height, right.height);
		return this;
	}



	public int size(){ //재귀로 모든 사이즈를 알아냄
		if(this == NIL) return 0;
		return 1+left.size()+right.size();

	}
	

	public String toString(){
		if(this==NIL)return "";
		//내림차순으로 나오게
		String a="";
	
		a = left+ key._element+" : "+key._count+" "+"h:"+height+"\n"+right ;

		return a;
	}
}
