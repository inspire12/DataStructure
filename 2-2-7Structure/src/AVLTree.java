
public class AVLTree {
	private Key key;
	private int height;
	private AVLTree left, right;

	public static int countAccess=0;
	public static final AVLTree NIL = new AVLTree();


	public AVLTree(String key){

		this.key = new Key(key,1);
		left = right = NIL;

	}

	public AVLTree(String key,int count){

		this.key = new Key(key,count);
		left = right = NIL;

	}
	//생성자 하나만 사용자가 쓸수 있게 통제 임의로 만들수 없게
	public AVLTree(){

		left = right =this;
		height=-1;

	}

	public AVLTree(Key key, AVLTree left, AVLTree right) {
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
		AVLTree.countAccess++;
	}
	private void incCount(){
		this.key._count++;
	}
	private AVLTree grow(String key){
		incAccess();

		if(this==NIL){ 
			return new AVLTree(key);}
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
		rebalance();
		
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
	private void rebalance(){
		if(right.height>left.height+1){
			if(right.left.height>right.right.height)
				right.rotateRight();
			rotateLeft();
		}else if(left.height>right.height+1){
			if(left.right.height>left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft(){
		left = new AVLTree(key,left, right.left);
		key = this.right.key; 
		right = this.right.right;
	}
	private void rotateRight(){
		right = new AVLTree(key,left.right, right);
		key = this.left.key; 
		left = this.left.left;
	}


}
