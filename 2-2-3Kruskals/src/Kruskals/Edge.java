package Kruskals;

public class Edge {

	private String _to;
	private String _from;
	private int _weight;
	
	public Edge(){
		this._to = null;
		this._from = null;
		this._weight = 0;
	}
	public Edge(String to, String from, int weight){
		this._to = to;
		this._from = from;
		this._weight = weight;
	}
	public void set(String to, String from, int weight){
		this._to = to;
		this._from = from;
		this._weight = weight;
		
	}
	public String get_to() {
		return _to;
	}
	public void set_to(String _to) {
		this._to = _to;
	}
	public String get_from() {
		return _from;
	}
	public void set_from(String _from) {
		this._from = _from;
	}
	public int get_weight() {
		return _weight;
	}
	public void set_weight(int _weight) {
		this._weight = _weight;
	}
	
}
