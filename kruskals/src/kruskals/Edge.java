package kruskals;

public class Edge {

	private String _head;
	private String _tail;
	private int _length;
	
	public Edge(){
		this._head = null;
		this._tail = null;
		this._length = 0;
	}
	public Edge(String h, String t, int l){
		this._head = h;
		this._tail = t;
		this._length = l;
	}
	public String get_head() {
		return _head;
	}
	public void set_head(String _head) {
		this._head = _head;
	}
	public String get_tail() {
		return _tail;
	}
	public void set_tail(String _tail) {
		this._tail = _tail;
	}
	public int get_length() {
		return _length;
	}
	public void set_length(int _length) {
		this._length = _length;
	}
	
}
