
public class singlyLinkedList {
	
	Node _head;

	private static int countAccess;
	
	public singlyLinkedList(String anElement,Node next){
		this._head=next;
	}
	public singlyLinkedList(String anElement){
		this._head=null;
	}
	public singlyLinkedList(){
		this._head=null;
		setCountAccess(0);
	}
	public boolean add(String anElement){
		if(search(anElement)){
	
		}else{		
		Node newNode=new Node(anElement,this._head);
		this._head=newNode;
		}
		
		return false;
	}
	private boolean search(String anElement){
		boolean found =false;
		Node currentNode = this._head;
		while(currentNode!=null&&!found){
			if(currentNode.get_element().equals(anElement)){
				found = true;
				currentNode.incCount();
				break;
			}
			currentNode=currentNode.next();
			incAccess();
		}
		return found;
	}
	
	private void incAccess(){
		setCountAccess(getCountAccess() + 1);
	}
	public Node get_next() {
		return _head;
	}

	public void set_next(Node _next) {
		this._head = _next;
	}

	
	public String toString(){
		String a="";
		Node searchNode = this._head;
		int newline=0;
		while(searchNode!=null){
			newline = (newline+1)%5;
			a+=searchNode.get_element()+" : " +searchNode._count+"  ";
			searchNode= searchNode.next();
			if(newline==4)a+="\n";
		}
		return a;
	}
	public int getCountAccess() {
		return countAccess;
	}
	public static void setCountAccess(int countAccess) {
		singlyLinkedList.countAccess = countAccess;
	}

}
