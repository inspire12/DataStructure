package Kruskals;

public class ArrayList<T>{
	
	private static final int DEFAULT_MAX_STACK_SIZE = 10;
	private int _maxSize;
	private int _top ;
	private T[] _elements ; //타입을 동적으로 선언 

	@SuppressWarnings("unchecked")
	public ArrayList(){
		this._maxSize = ArrayList.DEFAULT_MAX_STACK_SIZE;
		this._top = -1;
		this._elements = (T[]) new Object[ArrayList.DEFAULT_MAX_STACK_SIZE];
			
	}
	@SuppressWarnings("unchecked")
	public ArrayList(int maxSize){
		this._maxSize = maxSize;
		this._top = -1;
		this._elements = (T[]) new Object[ArrayList.DEFAULT_MAX_STACK_SIZE];
	}
	public int size(){
		return (this._top +1);
	}
	public boolean isEmpty(){
		return (this._top<0);
	}
	public boolean isFull(){
		return ((this._top+1)==this._maxSize);
	}
	public boolean push(T anElement) {
		// TODO Auto-generated method stub
		if(this.isFull()){
			return false;
		}else{
			this._top++;  //맨위 값을 올리고 
			this._elements[this._top]=anElement;  //그곳에 넣는다 
			return true;
		}
	}
	public T pop() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			return null;
		}else{
			T topelement =this._elements[this._top];
			this._top--;
			return topelement;
		}
	}
	public T peek() {
		// TODO Auto-generated method stub
		if(this.isEmpty()){
			return null;
		}else{
			return this._elements[this._top];
		}
	}
	public void clear(){
		while(this._top>=0){
			this._elements[this._top]=null;
			this._top--;
		}
	}
	public T elementAt(int order){
		return this._elements[order];
		
	}
}
