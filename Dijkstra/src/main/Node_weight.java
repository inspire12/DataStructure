package main;

public class Node_weight {
	//가중치 노드 만들기 
	
	private String _value;
	private Node_weight _next;
	private int _weight;
	
	public Node_weight(){
		this._value = null;
		this._next = null;
		this._weight = 0;
	}
	
	public Node_weight(String s){
		this._value = s;
		this._next = null;
		this._weight = 0;
	}
	
	
	public void setValue(String string) {
		// TODO Auto-generated method stub
		this._value = string;
	}

	public void setNext(Node_weight node) {
		// TODO Auto-generated method stub
		this._next = node;
	}

	public Node_weight getNext() {
		// TODO Auto-generated method stub
		return this._next;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return this._value;
	}

	public int get_weight() {
		return _weight;
	}

	public void set_weight(int _weight) {
		this._weight = _weight;
	}

}
